package cnu.kicksafe;

import android.graphics.Bitmap;

public class Profile {
    private double speed;
    private int helmetCount, usedTime;
    private String name;

    private Bitmap profileImage;
    private int type;
    private long id;

    Profile (long id, String name, double speed, int helmetCount, int usedTime, int type) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.helmetCount = helmetCount;
        this.usedTime = usedTime;
        this.type = type;
    }
    Profile () {
        this.type = 1;
    }

    public void setProfileImage (Bitmap image) {
        profileImage = image;
    }


    public int getType () {
        return type;
    }

    public String getName () {
        return name;
    }

    public double getSpeed () {
        return speed;
    }

    public int getHelmetCount () {
        return helmetCount;
    }

    public int getUsedTime () {
        return usedTime;
    }

    public Bitmap getProfileImage () {
        return profileImage;
    }

    public long getId () {
        return id;
    }


}
