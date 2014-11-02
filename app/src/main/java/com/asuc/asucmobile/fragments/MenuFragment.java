package com.asuc.asucmobile.fragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asuc.asucmobile.R;
import com.asuc.asucmobile.adapters.FoodAdapter;
import com.asuc.asucmobile.main.OpenDiningHallActivity;
import com.asuc.asucmobile.models.DiningHall;
import com.asuc.asucmobile.models.FoodItem;
import com.asuc.asucmobile.views.HeaderView;
import com.nirhart.parallaxscroll.views.ParallaxListView;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MenuFragment extends Fragment {

    private static final SimpleDateFormat HOURS_FORMAT =
            new SimpleDateFormat("h:mm a");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        ParallaxListView foodMenu = (ParallaxListView) v.findViewById(R.id.food_menu);
        TextView emptyListView = (TextView) v.findViewById(R.id.empty_list);

        emptyListView.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "young.ttf"));

        DiningHall diningHall = ((OpenDiningHallActivity) getActivity()).getDiningHall();
        HeaderView header = new HeaderView(getActivity());
        new DownloadImageTask(header).execute(diningHall.getImageUrl());

        try {
            ArrayList<FoodItem> foodItems;
            String headerString;
            boolean isOpen;
            String whichMenu = getArguments().getString("whichMenu");
            if (whichMenu.equals("Breakfast")) {
                foodItems = diningHall.getBreakfastMenu();
                String opening = HOURS_FORMAT.format(diningHall.getBreakfastOpening());
                String closing = HOURS_FORMAT.format(diningHall.getBreakfastClosing());
                headerString = "Breakfast Hours:  " + opening + " to " + closing + "  ";
                isOpen = diningHall.isBreakfastOpen();
            } else if (whichMenu.equals("Lunch")) {
                foodItems = diningHall.getLunchMenu();
                String opening = HOURS_FORMAT.format(diningHall.getLunchOpening());
                String closing = HOURS_FORMAT.format(diningHall.getLunchClosing());
                headerString = "Lunch Hours:  " + opening + " to " + closing + "  ";
                isOpen = diningHall.isLunchOpen();
            } else {
                foodItems = diningHall.getDinnerMenu();
                String opening = HOURS_FORMAT.format(diningHall.getDinnerOpening());
                String closing = HOURS_FORMAT.format(diningHall.getDinnerClosing());
                headerString = "Dinner Hours:  " + opening + " to " + closing + "  ";
                isOpen = diningHall.isDinnerOpen();
            }

            SpannableString spannableHeader;
            if (isOpen) {
                spannableHeader = new SpannableString(headerString + "OPEN");
                spannableHeader.setSpan(
                        new ForegroundColorSpan(Color.rgb(75, 220, 98)),
                        headerString.length(),
                        headerString.length() + 4,
                        SpannableString.SPAN_INCLUSIVE_EXCLUSIVE
                );
            } else {
                spannableHeader = new SpannableString(headerString + "CLOSED");
                spannableHeader.setSpan(
                        new ForegroundColorSpan(Color.RED),
                        headerString.length(),
                        headerString.length() + 6,
                        SpannableString.SPAN_INCLUSIVE_EXCLUSIVE
                );
            }

            header.setText(spannableHeader);

            FoodAdapter adapter = new FoodAdapter(getActivity(), foodItems);
            foodMenu.setAdapter(adapter);
            foodMenu.addParallaxedHeaderView(header);
        } catch (Exception e) { // Catch a null exception, meaning that there is no menu for this time slot.
            foodMenu.setVisibility(View.GONE);
            emptyListView.setVisibility(View.VISIBLE);
        }

        return v;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        HeaderView headerView;

        public DownloadImageTask(HeaderView headerView) {
            this.headerView = headerView;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap bitmap = null;

            try {
                InputStream input = new java.net.URL(url).openStream();
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                headerView.setImage(result);
            }
        }

    }

}
