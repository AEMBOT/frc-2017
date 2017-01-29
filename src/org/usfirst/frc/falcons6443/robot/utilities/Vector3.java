package org.usfirst.frc.falcons6443.robot.utilities;

/**
 * Expresses the features of a 3-dimensional array. Contains data to represent x, y, and z coordinates of an object
 * @author Shivashriganesh Mahato
 */
public class Vector3 {
    public float x;
    public float y;
    public float z;

    /**
     * Construct this object with x, y, and z set to 0
     */
    public Vector3() {
        this.setZero();
    }

    /**
     * Construct this object with raw x, y, and z parameters
     * @param x X component of vector
     * @param y Y component of vector
     * @param z Z component of vector
     */
    public Vector3(float x, float y, float z) {
        this.set(x, y, z);
    }

    /**
     * Construct this object with a predefined Vector3 object
     * @param vector The predefined Vector3 to construct this with
     */
    public Vector3(Vector3 vector) {
        this.set(vector);
    }

    /**
     * Set this vector with raw x, y, and z parameters
     * @param x X component of vector
     * @param y Y component of vector
     * @param z Z component of vector
     * @return This vector after setting values
     */
    public Vector3 set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    /**
     * Set this vector with predefined Vector3 object
     * @param vector The predefined Vector3 to construct this with
     * @return This vector after setting values
     */
    public Vector3 set(Vector3 vector) {
        return this.set(vector.x, vector.y, vector.z);
    }

    /**
     * Set this vector to 0 at x, y, and z
     * @return This vector after setting values
     */
    public Vector3 setZero() {
        return this.set(0, 0, 0);
    }

    /**
     * Add to this vector via raw x, y, and z parameters
     * @param dx Change in X to add
     * @param dy Change in Y to add
     * @param dz Change in Z to add
     * @return This vector after adding values
     */
    public Vector3 add(float dx, float dy, float dz) {
        return this.set(this.x + dx, this.y + dy, this.z + dz);
    }

    /**
     * Add to this vector with a raw delta parameter that will be added to each component
     * @param delta Change in X, Y, and Z to add to each
     * @return This vector after adding values
     */
    public Vector3 add(float delta) {
        return this.add(delta, delta, delta);
    }

    /**
     * Add to this vector with other Vector3 object
     * @param vector The other Vector3 object to add
     * @return This vector after adding
     */
    public Vector3 add(Vector3 vector) {
        return this.add(vector.x, vector.y, vector.z);
    }

    /**
     * Subtract from this vector raw x, y, and z parameters
     * @param dx Change in X to subtract
     * @param dy Change in Y to subtract
     * @param dz Change in Z to subtract
     * @return This vector after subtracting values
     */
    public Vector3 sub(float dx, float dy, float dz) {
        return this.set(this.x - dx, this.y - dy, this.z - dz);
    }

    /**
     * Subtract from this vector a raw delta parameter that will be subtracted from each component
     * @param delta Change in X, Y, and Z to subtract from each
     * @return This vector after subtracting values
     */
    public Vector3 sub(float delta) {
        return this.sub(delta, delta, delta);
    }

    /**
     * Subtract from this vector another Vector3 object
     * @param vector The other Vector3 object to subtract
     * @return This vector after subtracting
     */
    public Vector3 sub(Vector3 vector) {
        return this.sub(vector.x, vector.y, vector.z);
    }

    /**
     * Scale this vector with raw x, y, and z parameters
     * @param cx Scalar to multiply X by
     * @param cy Scalar to multiply Y by
     * @param cz Scalar to multiply Z by
     * @return This vector after scaling values
     */
    public Vector3 mult(float cx, float cy, float cz) {
        return this.set(this.x * cx, this.y * cy, this.z * cz);
    }

    /**
     * Scale this vector with a raw parameter that will be multiplied by each component
     * @param scalar Scalar value to multiply by X, Y, and Z each
     * @return This vector after scaling values
     */
    public Vector3 mult(float scalar) {
        return this.mult(scalar, scalar, scalar);
    }

    /**
     * Scale this vector with another Vector3 object
     * @param vector The other Vector3 object to multiply by
     * @return This vector after multiplying
     */
    public Vector3 mult(Vector3 vector) {
        return this.mult(vector.x, vector.y, vector.z);
    }
}
