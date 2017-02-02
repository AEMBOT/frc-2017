package org.usfirst.frc.falcons6443.robot.utilities;

/**
 * Expresses the features of a vector in 3 dimensions. Contains data to represent x, y, and z components of a vector
 * @author Ivan Kenevich, Shivashriganesh Mahato
 */
public class Vector3D {
	public float x;
	public float y;
	public float z;
	
    /**
     * Construct this object with x, y, and z set to 0
     */
    public Vector3D() {
        this.setZero();
    }

    /**
     * Construct this object with raw x, y, and z components
     * @param x X component of vector
     * @param y Y component of vector
     * @param z Z component of vector
     */
    public Vector3D(float x, float y, float z) {
        this.set(x, y, z);
    }
    
    /**
     * Construct vector that points from the origin to the predefined Point3D object
     * @param point The predefined Point3D to construct this with
     */
    public Vector3D(Point3D point) {
        this.set(point);
    }
    
    /**
     * Construct this object with a predefined Vector3D object
     * @param vector The predefined Vector3D to construct this with
     */
    public Vector3D(Vector3D vector) {
    	this.set(vector);
    }
    
    /**
     * Set this vector with raw x, y, and z parameters
     * @param x X component of vector
     * @param y Y component of vector
     * @param z Z component of vector
     * @return This vector after setting values
     */
    public Vector3D set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }
    
    /**
     * Set this vector with predefined Point3D object
     * @param point The predefined Point3D to construct this with
     * @return This vector after setting values
     */
    public Vector3D set(Point3D point) {
        return this.set(point.x, point.y, point.z);
    }
    
    /**
     * Set this vector with predefined Vector3D object
     * @param vector The predefined Vector3D to construct this with
     * @return This vector after setting values
     */
    public Vector3D set(Vector3D vector) {
        return this.set(vector.x, vector.y, vector.z);
    }

    /**
     * Set this vector to 0 at x, y, and z
     * @return This vector after setting values
     */
    public Vector3D setZero() {
        return this.set(0, 0, 0);
    }

    /**
     * Add to this vector via raw x, y, and z parameters
     * @param dx Change in X to add
     * @param dy Change in Y to add
     * @param dz Change in Z to add
     * @return This vector after adding values
     */
    public Vector3D add(float dx, float dy, float dz) {
        return this.set(this.x + dx, this.y + dy, this.z + dz);
    }

    /**
     * Scale this vector with raw x, y, and z parameters
     * @param cx Scalar to multiply X by
     * @param cy Scalar to multiply Y by
     * @param cz Scalar to multiply Z by
     * @return This vector after scaling values
     */
    public Vector3D scale(float cx, float cy, float cz) {
        return this.set(this.x * cx, this.y * cy, this.z * cz);
    }

    /**
     * Scale this vector with a raw parameter that will be multiplied by each component
     * @param scalar Scalar value to multiply by X, Y, and Z each
     * @return This vector after scaling values
     */
    public Vector3D scale(float scalar) {
        return this.scale(scalar, scalar, scalar);
    }
}
