package nz.net.initial3d;

/**
 * Initial3D Rendering API.
 *
 * Yes, much of this does mimic OpenGL 1 / 2.
 *
 *
 * @author Ben Allen
 *
 */
public abstract class Initial3D {

	/*
	 * Enum Constants
	 */

	public static final int ZERO = 0;
	public static final int ONE = 1;

	// capabilities
	public static final int SCISSOR_TEST = 2;
	public static final int ALPHA_TEST = 3;
	public static final int DEPTH_TEST = 4;
	public static final int STENCIL_TEST = 5;
	public static final int CULL_FACE = 6;
	public static final int BLEND = 7;
	public static final int FOG = 8;
	public static final int LIGHTING = 9;
	public static final int TWO_SIDED_LIGHTING = 10;
	public static final int TEXTURE_2D = 11;
	public static final int MIPMAPS = 12;
	public static final int AUTO_FLIP_ZSIGN = 13;
	public static final int ALPHAREF_RANDOM = 14;
	public static final int COLOR_SUM = 14;
	public static final int SEPARATE_SPECULAR = 16;

	public static final int LIGHT0 = 1000;
	public static final int LIGHT1 = 1001;
	public static final int LIGHT2 = 1002;
	public static final int LIGHT3 = 1003;
	public static final int LIGHT4 = 1004;
	public static final int LIGHT5 = 1005;
	public static final int LIGHT6 = 1006;
	public static final int LIGHT7 = 1007;
	public static final int LIGHT_MAX = 1999;
	public static final int CLIP_PLANE0 = 2000;
	public static final int CLIP_PLANE1 = 2001;
	public static final int CLIP_PLANE2 = 2002;
	public static final int CLIP_PLANE3 = 2003;
	public static final int CLIP_PLANE_MAX = 2999;

	// buffers, also represents write caps for each buffer
	public static final int BUFFER_COLOR0 = 10000;
	public static final int BUFFER_COLOR1 = 10001;
	public static final int BUFFER_Z = 10002;
	public static final int BUFFER_STENCIL = 10003;
	public static final int BUFFER_ID = 10004;

	// shademodels
	public static final int FLAT = 10100;
	public static final int SMOOTH = 10101;
	public static final int PHONG = 10102;

	// blend func parameters
	// share ZERO, ONE
	// idea: if COLOR_SUM is enabled, do 2 blends with both color buffers then add the result
	public static final int SRC_COLOR = 10200;
	public static final int ONE_MINUS_SRC_COLOR = 10201;
	public static final int DST_COLOR = 10202;
	public static final int ONE_MINUS_DST_COLOR = 10203;
	public static final int SRC_ALPHA = 10204;
	public static final int ONE_MINUS_SRC_ALPHA = 10205;
	public static final int DST_ALPHA = 10206;
	public static final int ONE_MINUS_DST_ALPHA = 10207;

	// comparison functions
	public static final int NEVER = 10300;
	public static final int LESS = 10301;
	public static final int LEQUAL = 10302;
	public static final int GREATER = 10303;
	public static final int GEQUAL = 10304;
	public static final int EQUAL = 10305;
	public static final int NOTEQUAL = 10306;
	public static final int ALWAYS = 10307;

	// stencil ops
	// stencil buffer as unsigned bytes
	// share ZERO
	public static final int KEEP = 10400;
	public static final int REPLACE = 10401;
	public static final int INCR = 10402; // clamp to 255
	public static final int INCR_WRAP = 10403; // wrap to 0
	public static final int DECR = 10404; // clamp to 0
	public static final int DECR_WRAP = 10405; // wrap to 255
	public static final int INVERT = 10406; // bitwise invert

	// faces
	public static final int FRONT = 10500;
	public static final int BACK = 10501;
	public static final int FRONT_AND_BACK = 10502;

	// light and material
	public static final int AMBIENT = 10600;
	public static final int DIFFUSE = 10601;
	public static final int SPECULAR = 10602;
	public static final int EMISSION = 10603;
	// opacity in diffuse alpha, shininess in specular alpha
	// but you can set them seperately of the color
	public static final int SHININESS = 10604;
	public static final int OPACITY = 10605;
	public static final int POSITION = 10606;
	public static final int SPOT_DIRECTION = 10607;
	public static final int CONSTANT_ATTENUATION = 10608;
	public static final int LINEAR_ATTENUATION = 10609;
	public static final int QUADRATIC_ATTENUATION = 10610;
	public static final int SPOT_CUTOFF = 10611;
	public static final int SPOT_EXPONENT = 10612;
	public static final int EFFECT_RADIUS = 10613;

	// texture targets
	public static final int TEXTURE_2D_KD = 10700;
	public static final int TEXTURE_2D_KS = 10701;
	public static final int TEXTURE_2D_KE = 10702;

	// drawing modes
	public static final int POINT = 10800;
	public static final int LINE = 10801;
	public static final int FILL = 10802;

	// projection mode (OpenGL does this implicitly)
	public static final int ORTHOGRAPHIC = 10900;
	public static final int PERSPECTIVE = 10901;

	// vertex attributes
	public static final int VERTEX_POSITION = 11000;
	public static final int VERTEX_NORMAL = 11001;
	public static final int VERTEX_COLOR0 = 11002;
	public static final int VERTEX_COLOR1 = 11003;
	public static final int VERTEX_TEXCOORD = 11004;

	public abstract FrameBuffer createFrameBuffer();

	// if null, revert to default
	public abstract void bindFrameBuffer(FrameBuffer fb);

	public abstract FrameBuffer getFrameBuffer();

	public abstract Texture2D createTexture2D(int size_u, int size_v);

	// if null, revert to default
	public abstract void bindTexture(int target, Texture2D tex);

	public abstract void enable(int cap);

	public abstract void disable(int cap);

	public abstract boolean isEnabled(int cap);

	public abstract void projectionMode(int mode);

	public abstract void polygonMode(int face, int mode);

	public abstract void shadeModel(int model);

	public abstract void viewport(int w, int h);

	public abstract void clear(int... buffers);

	// if null, revert to default (a fixed buffer with one zero vector)
	public abstract void bindVertexBuffer(int att, VectorBuffer vbuf);

	public abstract void drawPolygons(PolygonBuffer pbuf, int offset, int count);

	public abstract void begin(int mode);

	public abstract void vertex(double x, double y, double z);

	public void vertex(Vec3 v) {
		vertex(v.x, v.y, v.z);
	}

	public abstract void normal(double x, double y, double z);

	public void normal(Vec3 v) {
		normal(v.x, v.y, v.z);
	}

	public abstract void color(double r, double g, double b, double a);

	public void color(double r, double g, double b) {
		color(r, g, b, 1);
	}

	public void color(Color c) {
		color(c.r, c.g, c.b, c.a);
	}

	public abstract void secondaryColor(double r, double g, double b, double a);

	public void secondaryColor(double r, double g, double b) {
		color(r, g, b, 1);
	}

	public void secondaryColor(Color c) {
		color(c.r, c.g, c.b, c.a);
	}

	public abstract void texCoord(double u, double v);

	public void texCoord(Vec3 v) {
		texCoord(v.x, v.y);
	}

	public abstract void end();

	public abstract void material(int face, int param, double f);

	public abstract void material(int face, int param, double r, double g, double b, double a);

	public void material(int face, int param, double r, double g, double b) {
		material(face, param, r, g, b, 1);
	}

	public void material(int face, int param, Color c) {
		material(face, param, c.r, c.g, c.b, c.a);
	}

	public abstract void blendFunc(int sfactor, int dfactor);

	public abstract void alphaFunc(int func, double ref);

	public abstract void depthFunc(int func);

	public void stencilFunc(int func, int ref, int mask) {
		stencilFuncSeparate(FRONT_AND_BACK, func, ref, mask);
	}

	public abstract void stencilFuncSeparate(int face, int func, int ref, int mask);

	public void stencilOp(int sfail, int dfail, int dpass) {
		stencilOpSeparate(FRONT_AND_BACK, sfail, dfail, dpass);
	}

	public abstract void stencilOpSeparate(int face, int sfail, int dfail, int dpass);

	public abstract void light(int light, int param, double v);

	public abstract void light(int light, int param, double f0, double f1, double f2, double f3);

	public void light(int light, int param, double f0, double f1, double f2) {
		light(light, param, f0, f1, f2, 1);
	}

	public void light(int light, int param, Color c) {
		light(light, param, c.r, c.g, c.b, c.a);
	}

	public void light(int light, int param, Vec4 v) {
		light(light, param, v.x, v.y, v.z, v.w);
	}

	public void light(int light, int param, Vec3 v) {
		light(light, param, v.x, v.y, v.z);
	}

	public abstract void sceneAmbient(double r, double g, double b, double a);

	public void sceneAmbient(double r, double g, double b) {
		sceneAmbient(r, g, b, 1);
	}

	public void sceneAmbient(Color c) {
		sceneAmbient(c.r, c.g, c.b, c.a);
	}

	public abstract void cullFace(int face);

	// matrices

	public abstract void matrixMode(int mode);

	public abstract Vec4 transformOne(Vec3 v);

	public abstract Vec4 transformOne(Vec4 v);

	public abstract void pushMatrix();

	public abstract void popMatrix();

	public void loadIdentity() {
		loadMatrix(new Mat4());
	}

	public void pushIdentity() {
		pushMatrix();
		loadIdentity();
	}

	public abstract void loadMatrix(Mat4 m);

	public abstract void multMatrix(Mat4 m);

	public abstract Mat4 getMatrix();

	public void translate(Vec3 d) {
		multMatrix(d.toMatrix());
	}

	public void translate(double dx, double dy, double dz) {
		multMatrix(Mat4.createTranslate(dx, dy, dz));
	}

	public void scale(double f) {
		multMatrix(Mat4.createScale(f, f, f));
	}

	public void scale(Vec3 f) {
		multMatrix(Mat4.createScale(f.x, f.y, f.z));
	}

	public void scale(double fx, double fy, double fz) {
		multMatrix(Mat4.createScale(fx, fy, fz));
	}

	public void rotate(Quat q) {
		multMatrix(q.toMatrix());
	}

	public void rotate(double angle, Vec3 axis) {
		multMatrix(new Quat(angle, axis).toMatrix());
	}

	public void rotate(double angle, double ax, double ay, double az) {
		multMatrix(new Quat(angle, new Vec3(ax, ay, az)).toMatrix());
	}

}
