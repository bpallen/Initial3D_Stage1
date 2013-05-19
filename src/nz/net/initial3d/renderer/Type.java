package nz.net.initial3d.renderer;

/**
 *
 * Unsafe struct type field offsets and constants.
 *
 * @author Ben Allen
 *
 */
final class Type {

	private Type() {
		throw new AssertionError();
	}

	static final class i3d_t {

		private i3d_t() {
			throw new AssertionError();
		}

		/** Constant: size in bytes of an instance of this type */
		static int SIZEOF() {
			return 6620;
		}

		// in no particular order:

		// bound framebuffer -> make as type
		// enablers
		// projection mode
		// polygon mode, front + back
		// shade model
		// material, front + back [includes tex pointers]
		// blend func, front + back (sfactor, dfactor, mode)
		// alpha func (func, ref)
		// depth func
		// stencil func, front + back
		// stencil op, front + back
		// lights * >= 8
		// scene ambient
		// fog params (color, fog_a, fog_b)
		// face cull
		// matrices
		// clipfuncs
		// near clip
		// far cull
		// ** scissor rect

		// in some order:

		// enablers (flags)
		// projection mode
		// shade model
		// polygon mode, front + back
		// <other drawing modes, lines etc?>
		// matrices
		// face cull
		// near clip
		// far cull
		// clipfuncs
		// materials, front + back
		// scene ambient
		// lights [maybe 16?]
		// scissor rect
		// depth func
		// stencil func, front + back (func, ref, mask)
		// alpha func (func, ref)
		// stencil op, front + back (sfail, dfail, dpass)
		// blend func, front + back (sfactor, dfactor, mode)
		// fog params (color, fog_a, fog_b)
		// bound framebuffer

		/**
		 * Field type: long
		 * <p>
		 * (1 << 00) 0x0000000000000001: Write BUFFER_COLOR0<br>
		 * (1 << 01) 0x0000000000000002: Write BUFFER_COLOR1<br>
		 * (1 << 02) 0x0000000000000004: Write BUFFER_Z<br>
		 * (1 << 03) 0x0000000000000008: Write BUFFER_STENCIL<br>
		 * (1 << 04) 0x0000000000000010: Write BUFFER_ID<br>
		 * (1 << 05) 0x0000000000000020: SCISSOR_TEST<br>
		 * (1 << 06) 0x0000000000000040: ALPHA_TEST<br>
		 * (1 << 07) 0x0000000000000080: DEPTH_TEST<br>
		 * (1 << 08) 0x0000000000000100: STENCIL_TEST<br>
		 * (1 << 09) 0x0000000000000200: CULL_FACE<br>
		 * (1 << 10) 0x0000000000000400: BLEND<br>
		 * (1 << 11) 0x0000000000000800: FOG<br>
		 * (1 << 12) 0x0000000000001000: LIGHTING<br>
		 * (1 << 13) 0x0000000000002000: TWO_SIDED_LIGHTING<br>
		 * (1 << 14) 0x0000000000004000: TEXTURE_2D<br>
		 * (1 << 15) 0x0000000000008000: MIPMAPS<br>
		 * (1 << 16) 0x0000000000010000: COLOR_SUM<br>
		 * (1 << 17) 0x0000000000020000: SEPARATE_SPECULAR<br>
		 * (1 << 18) 0x0000000000040000: <br>
		 * (1 << 19) 0x0000000000080000: <br>
		 * (1 << 20) 0x0000000000100000: <br>
		 * (1 << 21) 0x0000000000200000: <br>
		 * (1 << 22) 0x0000000000400000: <br>
		 * (1 << 23) 0x0000000000800000: <br>
		 * (1 << 24) 0x0000000001000000: <br>
		 * (1 << 25) 0x0000000002000000: <br>
		 * (1 << 26) 0x0000000004000000: <br>
		 * (1 << 27) 0x0000000008000000: <br>
		 * (1 << 28) 0x0000000010000000: <br>
		 * (1 << 29) 0x0000000020000000: <br>
		 * (1 << 30) 0x0000000040000000: <br>
		 * (1 << 31) 0x0000000080000000: <br>
		 * </p>
		 */
		static int flags0() {
			return 0;
		}

		/**
		 * Field type: long
		 * <p>
		 * Reserved for future use.
		 * </p>
		 */
		static int flags1() {
			return 8;
		}

		/**
		 * Field type: int
		 * <p>
		 * 0: ORTHOGRAPHIC<br>
		 * 1: PERSPECTIVE<br>
		 * </p>
		 */
		static int projection_mode() {
			return 16;
		}

		/**
		 * Field type: int
		 * <p>
		 * 0: FLAT<br>
		 * 1: SMOOTH<br>
		 * 2: PHONG<br>
		 * </p>
		 */
		static int shade_model() {
			return 20;
		}

		/**
		 * Field type: int
		 * <p>
		 * 0: POINT<br>
		 * 1: LINE<br>
		 * 2: FILL<br>
		 * </p>
		 */
		static int polymode_front() {
			return 24;
		}

		/**
		 * Field type: int
		 * <p>
		 * 0: POINT<br>
		 * 1: LINE<br>
		 * 2: FILL<br>
		 * </p>
		 */
		static int polymode_back() {
			return 28;
		}

		// reserved for other modes etc -> 88

		/** Field type: mat4 */
		static int mat_mv() {
			return 88;
		}

		/** Field type: mat4 */
		static int mat_p() {
			return 216;
		}

		/** Field type: mat4 */
		static int mat_mvp() {
			return 344;
		}

		/** Field type: mat4 */
		static int mat_inv_mv() {
			return 472;
		}

		/** Field type: mat4 */
		static int mat_inv_p() {
			return 600;
		}

		/** Field type: mat4 */
		static int mat_inv_mvp() {
			return 728;
		}

		/** Field type: mat4 */
		static int mat_n() {
			return 856;
		}

		/** Field type: mat4 */
		static int mat_inv_n() {
			return 984;
		}

		/** Field type: mat4 */
		static int mat_t() {
			return 1112;
		}

		/** Field type: mat4 */
		static int mat_inv_t() {
			return 1240;
		}

		/**
		 * Field type: int
		 * <p>
		 * 0: NONE<br>
		 * 1: FRONT<br>
		 * 2: BACK<br>
		 * 3: FRONT_AND_BACK<br>
		 * </p>
		 */
		static int face_cull() {
			return 1368;
		}

		/**
		 * Field type: double
		 * <p>
		 * Distance in view space to near clip plane.
		 * </p>
		 */
		static int near_clip() {
			return 1372;
		}

		/**
		 * Field type: double
		 * <p>
		 * Distance beyond which if a primitive falls completely it should be
		 * culled.
		 * </p>
		 */
		static int far_cull() {
			return 1380;
		}

		/** Field type: clipfunc */
		static int clip_top() {
			return 1388;
		}

		/** Field type: clipfunc */
		static int clip_bottom() {
			return 1420;
		}

		/** Field type: clipfunc */
		static int clip_left() {
			return 1452;
		}

		/** Field type: clipfunc */
		static int clip_right() {
			return 1484;
		}

		/**
		 * Field type: clipfunc
		 * <p>
		 * First custom clipfunc.
		 * </p>
		 */
		static int clip0() {
			return 1516;
		}

		/** Constant: maximum number of custom clipfuncs supported. */
		static int MAX_CLIPFUNCS() {
			return 8;
		}

		/** Field type: none, marks end of custom clipfuncs. */
		static int clip_end() {
			return 1772;
		}

		// reserved for (8) user clipfuncs -> 1772

		/** Field type: material */
		static int mtl_front() {
			return 1772;
		}

		/** Field type: material */
		static int mtl_back() {
			return 2028;
		}

		/** Field type: color[float] */
		static int scene_ambient() {
			return 2284;
		}

		/** Field type: light */
		static int light0() {
			return 2300;
		}

		/** Constant: maximum number of lights supported. */
		static int MAX_LIGHTS() {
			return 16;
		}

		/** Field type: none; marks end of lights */
		static int light_end() {
			return 6396;
		}

		/** Field type: int */
		static int scissor_xmin() {
			return 6396;
		}

		/** Field type: int */
		static int scissor_xmax() {
			return 6400;
		}

		/** Field type: int */
		static int scissor_ymin() {
			return 6404;
		}

		/** Field type: int */
		static int scissor_ymax() {
			return 6408;
		}

		/** Field type: int */
		static int depth_func() {
			return 6412;
		}

		/** Field type: int */
		static int stencil_func_front() {
			return 6416;
		}

		/** Field type: int */
		static int stencil_func_front_ref() {
			return 6420;
		}

		/** Field type: int */
		static int stencil_func_front_mask() {
			return 6424;
		}

		/** Field type: int */
		static int stencil_func_back() {
			return 6428;
		}

		/** Field type: int */
		static int stencil_func_back_ref() {
			return 6432;
		}

		/** Field type: int */
		static int stencil_func_back_mask() {
			return 6436;
		}

		/** Field type: int */
		static int alpha_func() {
			return 6440;
		}

		/** Field type: int */
		static int stencil_op_front_sfail() {
			return 6444;
		}

		/** Field type: int */
		static int stencil_op_front_dfail() {
			return 6448;
		}

		/** Field type: int */
		static int stencil_op_front_dpass() {
			return 6452;
		}

		/** Field type: int */
		static int stencil_op_back_sfail() {
			return 6456;
		}

		/** Field type: int */
		static int stencil_op_back_dfail() {
			return 6460;
		}

		/** Field type: int */
		static int stencil_op_back_dpass() {
			return 6464;
		}

		/** Field type: int */
		static int blend_func_front_sfactor() {
			return 6468;
		}

		/** Field type: int */
		static int blend_func_front_dfactor() {
			return 6472;
		}

		/** Field type: int */
		static int blend_func_front_mode() {
			return 6476;
		}

		/** Field type: int */
		static int blend_func_back_sfactor() {
			return 6480;
		}

		/** Field type: int */
		static int blend_func_back_dfactor() {
			return 6484;
		}

		/** Field type: int */
		static int blend_func_back_mode() {
			return 6488;
		}

		/** Field type: color[float] */
		static int fog_color() {
			return 6492;
		}

		/** Field type: float */
		static int fog_a() {
			return 6508;
		}

		/** Field type: float */
		static int fog_b() {
			return 6512;
		}

		/** Field type: framebuf */
		static int framebuf() {
			return 6516;
		}

	}

	static final class framebuf_t {

		private framebuf_t() {
			throw new AssertionError();
		}

		/** Constant: size in bytes of an instance of this type */
		static int SIZEOF() {
			return 104;
		}

		/** Field type: int */
		static int viewport_x() {
			return 0;
		}

		/** Field type: int */
		static int viewport_y() {
			return 4;
		}

		/** Field type: int */
		static int viewport_w() {
			return 8;
		}

		/** Field type: int */
		static int viewport_h() {
			return 12;
		}

		/** Field type: pointer */
		static int pColor0() {
			return 16;
		}

		/** Field type: int */
		static int stride_color0() {
			return 24;
		}

		/** Field type: pointer */
		static int pColor1() {
			return 28;
		}

		/** Field type: int */
		static int stride_color1() {
			return 36;
		}

		/** Field type: pointer */
		static int pZ() {
			return 40;
		}

		/** Field type: int */
		static int stride_z() {
			return 48;
		}

		/** Field type: pointer */
		static int pSZ() {
			return 52;
		}

		/** Field type: int */
		static int stride_sz() {
			return 60;
		}

		/** Field type: pointer */
		static int pZSign() {
			return 64;
		}

		/** Field type: pointer */
		static int pStencil() {
			return 72;
		}

		/** Field type: int */
		static int stride_stencil() {
			return 80;
		}

		/** Field type: pointer */
		static int pID() {
			return 84;
		}

		/** Field type: int */
		static int stride_id() {
			return 92;
		}

		/** Field type: pointer */
		static int pFC() {
			return 96;
		}

	}

	static final class light_t {

		private light_t() {
			throw new AssertionError();
		}

		/** Constant: size in bytes of an instance of this type */
		static int SIZEOF() {
			return 256;
		}

		/** Field type: int; 0x1 => enabled, 0x2 => last */
		static int flags() {
			return 0;
		}

		/** Field type: float */
		static int ia_a() {
			return 4;
		}

		/** Field type: float */
		static int ia_r() {
			return 8;
		}

		/** Field type: float */
		static int ia_g() {
			return 12;
		}

		/** Field type: float */
		static int ia_b() {
			return 16;
		}

		/** Field type: float */
		static int id_a() {
			return 20;
		}

		/** Field type: float */
		static int id_r() {
			return 24;
		}

		/** Field type: float */
		static int id_g() {
			return 28;
		}

		/** Field type: float */
		static int id_b() {
			return 32;
		}

		/** Field type: float */
		static int is_a() {
			return 36;
		}

		/** Field type: float */
		static int is_r() {
			return 40;
		}

		/** Field type: float */
		static int is_g() {
			return 44;
		}

		/** Field type: float */
		static int is_b() {
			return 48;
		}

		// note: .pos and .dir stored in view space so no need for double

		/** Field type: float */
		static int pos_x() {
			return 52;
		}

		/** Field type: float */
		static int pos_y() {
			return 56;
		}

		/** Field type: float */
		static int pos_z() {
			return 60;
		}

		/** Field type: float */
		static int pos_w() {
			return 64;
		}

		/** Field type: float */
		static int dir_x() {
			return 68;
		}

		/** Field type: float */
		static int dir_y() {
			return 72;
		}

		/** Field type: float */
		static int dir_z() {
			return 76;
		}

		/** Field type: float */
		static int dir_w() {
			return 80;
		}

		/** Field type: float */
		static int constant_attenuation() {
			return 84;
		}

		/** Field type: float */
		static int linear_attenuation() {
			return 88;
		}

		/** Field type: float */
		static int quadratic_attenuation() {
			return 92;
		}

		/** Field type: float */
		static int spot_cutoff() {
			return 96;
		}

		/** Field type: float */
		static int spot_exp() {
			return 100;
		}

		/** Field type: float */
		static int inv_effect_rad() {
			return 104;
		}

	}

	static final class material_t {

		private material_t() {
			throw new AssertionError();
		}

		/** Constant: size in bytes of an instance of this type */
		static int SIZEOF() {
			return 256;
		}

		static int ka_a_unused() {
			return 0;
		}

		/** Field type: float */
		static int ka_r() {
			return 4;
		}

		/** Field type: float */
		static int ka_g() {
			return 8;
		}

		/** Field type: float */
		static int ka_b() {
			return 12;
		}

		/** Field type: float */
		static int kd_a_opacity() {
			return 16;
		}

		/** Field type: float */
		static int kd_r() {
			return 20;
		}

		/** Field type: float */
		static int kd_g() {
			return 24;
		}

		/** Field type: float */
		static int kd_b() {
			return 28;
		}

		/** Field type: float */
		static int ks_a_shininess() {
			return 32;
		}

		/** Field type: float */
		static int ks_r() {
			return 36;
		}

		/** Field type: float */
		static int ks_g() {
			return 40;
		}

		/** Field type: float */
		static int ks_b() {
			return 44;
		}

		static int ke_a_unused() {
			return 48;
		}

		/** Field type: float */
		static int ke_r() {
			return 52;
		}

		/** Field type: float */
		static int ke_g() {
			return 56;
		}

		/** Field type: float */
		static int ke_b() {
			return 60;
		}

		/** Field type: pointer */
		static int pMap_kd() {
			return 64;
		}

		/** Field type: pointer */
		static int pMap_ks() {
			return 72;
		}

		/** Field type: pointer */
		static int pMap_ke() {
			return 80;
		}

	}

	static final class tri_t {

		private tri_t() {
			throw new AssertionError();
		}

		/** Constant: size in bytes of an instance of this type */
		static int SIZEOF() {
			return 196;
		}

		/** Field type: int; 0x1 => deleted, 0x2 => cw, else ccw */
		static int flags() {
			return 0;
		}

		/** Field type: pointer */
		static int pv0() {
			return 4;
		}

		/** Field type: pointer */
		static int pvt0() {
			return 12;
		}

		/** Field type: pointer */
		static int pvn0() {
			return 20;
		}

		/** Field type: pointer */
		static int pvv0() {
			return 28;
		}

		/** Field type: float */
		static int v0_c0_a() {
			return 36;
		}

		/** Field type: float */
		static int v0_c0_r() {
			return 40;
		}

		/** Field type: float */
		static int v0_c0_g() {
			return 44;
		}

		/** Field type: float */
		static int v0_c0_b() {
			return 48;
		}

		/** Field type: float */
		static int v0_c1_a() {
			return 52;
		}

		/** Field type: float */
		static int v0_c1_r() {
			return 56;
		}

		/** Field type: float */
		static int v0_c1_g() {
			return 60;
		}

		/** Field type: float */
		static int v0_c1_b() {
			return 64;
		}

		/** Field type: pointer */
		static int pv1() {
			return 68;
		}

		/** Field type: pointer */
		static int pvt1() {
			return 76;
		}

		/** Field type: pointer */
		static int pvn1() {
			return 84;
		}

		/** Field type: pointer */
		static int pvv1() {
			return 92;
		}

		/** Field type: float */
		static int v1_c0_a() {
			return 100;
		}

		/** Field type: float */
		static int v1_c0_r() {
			return 104;
		}

		/** Field type: float */
		static int v1_c0_g() {
			return 108;
		}

		/** Field type: float */
		static int v1_c0_b() {
			return 112;
		}

		/** Field type: float */
		static int v1_c1_a() {
			return 116;
		}

		/** Field type: float */
		static int v1_c1_r() {
			return 120;
		}

		/** Field type: float */
		static int v1_c1_g() {
			return 124;
		}

		/** Field type: float */
		static int v1_c1_b() {
			return 128;
		}

		/** Field type: pointer */
		static int pv2() {
			return 132;
		}

		/** Field type: pointer */
		static int pvt2() {
			return 140;
		}

		/** Field type: pointer */
		static int pvn2() {
			return 148;
		}

		/** Field type: pointer */
		static int pvv2() {
			return 156;
		}

		/** Field type: float */
		static int v2_c0_a() {
			return 164;
		}

		/** Field type: float */
		static int v2_c0_r() {
			return 168;
		}

		/** Field type: float */
		static int v2_c0_g() {
			return 172;
		}

		/** Field type: float */
		static int v2_c0_b() {
			return 176;
		}

		/** Field type: float */
		static int v2_c1_a() {
			return 180;
		}

		/** Field type: float */
		static int v2_c1_r() {
			return 184;
		}

		/** Field type: float */
		static int v2_c1_g() {
			return 188;
		}

		/** Field type: float */
		static int v2_c1_b() {
			return 192;
		}

	}

	static final class polyvert_t {

		private polyvert_t() {
			throw new AssertionError();
		}

		/** Constant: size in bytes of an instance of this type */
		static int SIZEOF() {
			return 64;
		}

		// need flags word, vertex count if first vertex in poly, 2 colors per
		// vertex

	}

	static final class clipfunc_t {

		private clipfunc_t() {
			throw new AssertionError();
		}

		/** Constant: size in bytes of an instance of this type */
		static int SIZEOF() {
			return 32;
		}

		/** Field type: double */
		static int cx() {
			return 0;
		}

		/** Field type: double */
		static int cy() {
			return 8;
		}

		/** Field type: double */
		static int cz() {
			return 16;
		}

		/** Field type: double */
		static int cutoff() {
			return 24;
		}

	}

	static final class tex2d_t {

		private tex2d_t() {
			throw new AssertionError();
		}

		/** Field type: short; 0x1 => mipmaps */
		static int flags() {
			return 0;
		}

		/** Field type: byte */
		static int ufloor() {
			return 2;
		}

		/** Field type: byte */
		static int vfloor() {
			return 3;
		}

		/** Field type: byte */
		static int uceil() {
			return 4;
		}

		/** Field type: byte */
		static int vceil() {
			return 5;
		}

	}

}
