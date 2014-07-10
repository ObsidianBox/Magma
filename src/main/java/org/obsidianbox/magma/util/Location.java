package org.obsidianbox.magma.util;

import java.io.Serializable;

/**
 * Simple Location object
 * @author bensku
 *
 */
public class Location implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -2035269691130737927L;
    
    //Use doubles because only blocks use int locations
    private double x;
    private double y;
    private double z;
    
    public Location(double x, double y, double z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
    @Override
    public String toString() {
        return "Location={" + "x=" + this.getX() + ",y=" + this.getY() + ",z=" + this.getZ() + "}";
    }
}
