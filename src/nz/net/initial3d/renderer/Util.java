package nz.net.initial3d.renderer;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

import nz.net.initial3d.*;

final class Util {

	private static Unsafe unsafe;

	private Util() {
		throw new AssertionError("You're doing it wrong.");
	}

	/** Get the <code>sun.misc.Unsafe</code> singleton. */
	static Unsafe getUnsafe() {
		if (unsafe == null) {
			try {
				Field field = Unsafe.class.getDeclaredField("theUnsafe");
				field.setAccessible(true);
				unsafe = (Unsafe) field.get(null);
			} catch (Throwable t) {
				throw nope("Failed to obtain the sun.misc.Unsafe singleton.", t);
			}
		}
		return unsafe;
	}

	/**
	 * Fast approximation for inverse square root of a positive float. From <a
	 * href=http://en.wikipedia.org/wiki/Fast_inverse_square_root>Wikipedia</a>.
	 */
	static float fastInverseSqrt(float x) {
		float x2 = x * 0.5f;
		// evil floating point bit level hacking
		x = Float.intBitsToFloat(0x5f3759df - (Float.floatToRawIntBits(x) >>> 1));
		// 1st iteration of newton's method
		x = x * (1.5f - (x2 * x * x));
		return x;
	}

	/**
	 * Fast approximation for inverse of a positive float. Identical to
	 * <code>fastInverseSqrt()</code>, except the operand is squared.
	 */
	static float fastInverse(float x) {
		x *= x;
		float x2 = x * 0.5f;
		// evil floating point bit level hacking
		x = Float.intBitsToFloat(0x5f3759df - (Float.floatToRawIntBits(x) >>> 1));
		// 1st iteration of newton's method
		x = x * (1.5f - (x2 * x * x));
		return x;
	}

	static double clamp(double value, double lower, double upper) {
		return value < lower ? lower : value > upper ? upper : value;
	}

	static float clamp(float value, float lower, float upper) {
		return value < lower ? lower : value > upper ? upper : value;
	}

	static long clamp(long value, long lower, long upper) {
		return value < lower ? lower : value > upper ? upper : value;
	}

	static int clamp(int value, int lower, int upper) {
		return value < lower ? lower : value > upper ? upper : value;
	}

	/** Wrapper for <code>System.currentTimeMillis()</code>. */
	static long time() {
		return System.currentTimeMillis();
	}

	/** Wrapper for <code>System.nanoTime()</code>. */
	static long timenanos() {
		return System.nanoTime();
	}

	/** Wrapper for <code>System.out.printf()</code>. */
	static void printf(String fmt, Object... args) {
		System.out.printf(fmt, args);
	}

	/** Wrapper for <code>String.format()</code>. */
	static String sprintf(String fmt, Object... args) {
		return String.format(fmt, args);
	}

	/** Wrapper for <code>System.out.println()</code>. */
	static void puts(Object s) {
		System.out.println(s);
	}

	/**
	 * Wrapper for <code>Thread.sleep()</code> that suppresses
	 * InterruptedException.
	 */
	static void pause(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// do nothing
		}
	}

	/**
	 * Throw a new I3DException with the specified message. Is declared to
	 * return I3DException for convenience only.
	 */
	static I3DException nope(String msg) {
		throw new I3DException(msg);
	}

	/**
	 * Throw a new I3DException with the specified message and cause. Is
	 * declared to return I3DException for convenience only.
	 */
	static I3DException nope(String msg, Throwable cause) {
		throw new I3DException(msg, cause);
	}

	static void writeMat(Unsafe unsafe, long pTarget, Mat4 m) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++, pTarget += 8) {
				unsafe.putDouble(pTarget, m.get(i, j));
			}
		}
	}

	static void writeVector(Unsafe unsafe, long pTarget, double x, double y, double z, double w) {
		unsafe.putDouble(pTarget, x);
		unsafe.putDouble(pTarget + 8, y);
		unsafe.putDouble(pTarget + 16, z);
		unsafe.putDouble(pTarget + 24, w);
	}

	static double vectorDot(Unsafe unsafe, long pVec, double cx, double cy, double cz) {
		double dot = unsafe.getDouble(pVec) * cx;
		dot += unsafe.getDouble(pVec + 8) * cy;
		dot += unsafe.getDouble(pVec + 16) * cz;
		return dot;
	}

	static double vectorDot(Unsafe unsafe, long pVecA, long pVecB) {
		double dot = unsafe.getDouble(pVecA) * unsafe.getDouble(pVecB);
		dot += unsafe.getDouble(pVecA + 8) * unsafe.getDouble(pVecB + 8);
		dot += unsafe.getDouble(pVecA + 16) * unsafe.getDouble(pVecB + 16);
		return dot;
	}

	static void vectorPlaneNorm(Unsafe unsafe, long pTarget, long pVec0, long pVec1, long pVec2) {
		double dx01 = unsafe.getDouble(pVec1) - unsafe.getDouble(pVec0);
		double dy01 = unsafe.getDouble(pVec1 + 8) - unsafe.getDouble(pVec0 + 8);
		double dz01 = unsafe.getDouble(pVec1 + 16) - unsafe.getDouble(pVec0 + 16);
		double dx12 = unsafe.getDouble(pVec2) - unsafe.getDouble(pVec1);
		double dy12 = unsafe.getDouble(pVec2 + 8) - unsafe.getDouble(pVec1 + 8);
		double dz12 = unsafe.getDouble(pVec2 + 16) - unsafe.getDouble(pVec1 + 16);
		// now do d01 cross d12
		unsafe.putDouble(pTarget, dy01 * dz12 - dz01 * dy12);
		unsafe.putDouble(pTarget + 8, dz01 * dx12 - dx01 * dz12);
		unsafe.putDouble(pTarget + 16, dx01 * dy12 - dy01 * dx12);
		unsafe.putDouble(pTarget + 24, 1);
	}

	static void vectorCross(Unsafe unsafe, long pTarget, long pVec0, long pVec1) {
		double x0 = unsafe.getDouble(pVec0);
		double y0 = unsafe.getDouble(pVec0 + 8);
		double z0 = unsafe.getDouble(pVec0 + 16);
		double x1 = unsafe.getDouble(pVec1);
		double y1 = unsafe.getDouble(pVec1 + 8);
		double z1 = unsafe.getDouble(pVec1 + 16);
		unsafe.putDouble(pTarget, y0 * z1 - z0 * y1);
		unsafe.putDouble(pTarget + 8, z0 * x1 - x0 * z1);
		unsafe.putDouble(pTarget + 16, x0 * y1 - y0 * x1);
		unsafe.putDouble(pTarget + 24, 1);
	}

	static void interpolateVectors(Unsafe unsafe, long pTarget, long pA, double cA, long pB, double cB) {
		for (int q = 0; q < 32; q += 8) {
			unsafe.putDouble(pTarget + q, unsafe.getDouble(pA + q) * cA + unsafe.getDouble(pB + q) * cB);
		}
	}

	static void interpolateVectors_float(Unsafe unsafe, long pTarget, long pA, float cA, long pB, float cB) {
		for (int q = 0; q < 16; q += 4) {
			unsafe.putFloat(pTarget + q, unsafe.getFloat(pA + q) * cA + unsafe.getFloat(pB + q) * cB);
		}
	}

	/**
	 * Left-multiply a block of position vectors (assumed homogenised) by a
	 * transformation matrix and homogenise them, setting the w component to the
	 * inverse of its non-homogenised value.
	 *
	 * @param size
	 *            number of vectors in block
	 */
	public static final void multiply4VectorBlock_pos(Unsafe unsafe, long pTarget, long pMat, long pVec0, long size) {
		// read in xform
		final double x00 = unsafe.getDouble(pMat);
		final double x01 = unsafe.getDouble(pMat += 8);
		final double x02 = unsafe.getDouble(pMat += 8);
		final double x03 = unsafe.getDouble(pMat += 8);

		final double x10 = unsafe.getDouble(pMat += 8);
		final double x11 = unsafe.getDouble(pMat += 8);
		final double x12 = unsafe.getDouble(pMat += 8);
		final double x13 = unsafe.getDouble(pMat += 8);

		final double x20 = unsafe.getDouble(pMat += 8);
		final double x21 = unsafe.getDouble(pMat += 8);
		final double x22 = unsafe.getDouble(pMat += 8);
		final double x23 = unsafe.getDouble(pMat += 8);

		final double x30 = unsafe.getDouble(pMat += 8);
		final double x31 = unsafe.getDouble(pMat += 8);
		final double x32 = unsafe.getDouble(pMat += 8);
		final double x33 = unsafe.getDouble(pMat += 8);

		final long pVecLast = pVec0 + (size << 5);

		// xform and homogenise
		while (pVec0 < pVecLast) {
			// read vector to apply xform to
			double r0 = unsafe.getDouble(pVec0);
			double r1 = unsafe.getDouble(pVec0 += 8);
			double r2 = unsafe.getDouble(pVec0 += 8);
			// assume r3 == 1

			double it3 = 1d / (x30 * r0 + x31 * r1 + x32 * r2 + x33);

			// xform
			unsafe.putDouble(pTarget, (x00 * r0 + x01 * r1 + x02 * r2 + x03) * it3);
			unsafe.putDouble(pTarget += 8, (x10 * r0 + x11 * r1 + x12 * r2 + x13) * it3);
			unsafe.putDouble(pTarget += 8, (x20 * r0 + x21 * r1 + x22 * r2 + x23) * it3);
			unsafe.putDouble(pTarget += 8, it3);

			pVec0 += 16;
			pTarget += 8;
		}
	}

	/**
	 * Left-multiply a block of normal vectors by a transformation matrix and
	 * normalise them.
	 *
	 * @param size
	 *            number of vectors in block
	 */
	public static final void multiply4VectorBlock_norm(Unsafe unsafe, long pTarget, long pMat, long pVec0, long size) {
		// read in xform (don't actually need all of it)
		final double x00 = unsafe.getDouble(pMat);
		final double x01 = unsafe.getDouble(pMat += 8);
		final double x02 = unsafe.getDouble(pMat += 8);
		pMat += 8;
		final double x10 = unsafe.getDouble(pMat += 8);
		final double x11 = unsafe.getDouble(pMat += 8);
		final double x12 = unsafe.getDouble(pMat += 8);
		pMat += 8;
		final double x20 = unsafe.getDouble(pMat += 8);
		final double x21 = unsafe.getDouble(pMat += 8);
		final double x22 = unsafe.getDouble(pMat += 8);

		final long pVecLast = pVec0 + (size << 5);

		// xform and normalise
		while (pVec0 < pVecLast) {
			// read vector to apply xform to
			double r0 = unsafe.getDouble(pVec0);
			double r1 = unsafe.getDouble(pVec0 += 8);
			double r2 = unsafe.getDouble(pVec0 += 8);
			// assume r3 == 0

			// xform
			double t0 = x00 * r0 + x01 * r1 + x02 * r2;
			double t1 = x10 * r0 + x11 * r1 + x12 * r2;
			double t2 = x20 * r0 + x21 * r1 + x22 * r2;

			double im = 1d / Math.sqrt(t0 * t0 + t1 * t1 + t2 * t2);

			unsafe.putDouble(pTarget, t0 * im);
			unsafe.putDouble(pTarget += 8, t1 * im);
			unsafe.putDouble(pTarget += 8, t2 * im);
			unsafe.putDouble(pTarget += 8, 0d);

			pVec0 += 16;
			pTarget += 8;
		}
	}

}
