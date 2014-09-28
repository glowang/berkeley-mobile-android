package com.asuc.asucmobile.models;

import java.util.Date;

public class Gym {

    private String id;
    private String name;
    private String address;
    private Date opening;
    private Date closing;

    public Gym(String id, String name, String address, Date opening, Date closing) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.opening = opening;
        this.closing = closing;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getOpening() {
        return opening;
    }

    public Date getClosing() {
        return closing;
    }

    /**
     * isOpen() returns whether or not the facility is open.
     *
     * @return Boolean indicating if the library is open or not.
     */
    public boolean isOpen() {
        if (opening == null || closing == null) {
            return false;
        }

        Date currentTime = new Date();
        return currentTime.after(opening) && currentTime.before(closing);
    }

}
