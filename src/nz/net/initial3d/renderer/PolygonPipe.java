package nz.net.initial3d.renderer;

import static nz.net.initial3d.renderer.Util.*;
import static nz.net.initial3d.renderer.Type.*;
import sun.misc.Unsafe;

final class PolygonPipe {

	// TODO idea - change to 'GeometryPipe', accept lines / points aswell

	private static final Unsafe unsafe = getUnsafe();

	private final long pPolyTemp;

	private RasterPipe rasterpipe;

	PolygonPipe() {
		pPolyTemp = unsafe.allocateMemory(polyvert_t.SIZEOF() * 2048);
	}

	@Override
	protected void finalize() {
		unsafe.freeMemory(pPolyTemp);
	}

	void connectRasterPipe(RasterPipe rp) {
		rasterpipe = rp;
	}

	void finish() {
		// nothing to do here, just finish the raster pipe
		rasterpipe.finish();
	}

	/**
	 * This pipe is synchronous so can use client-side state (but vector buffers and polygon buffers aren't really
	 * client state anyway).
	 *
	 * @param stride
	 *            units are array indices
	 */
	void feed(Initial3DImpl.State state, int[] data, int offset, int stride, int count) {
		final Unsafe unsafe = PolygonPipe.unsafe;
		// final long pBase = this.pBase;
		// allocate memory to hold all transformed vertex data, any vertex data
		// generated in-pipe and generated raster primitives
		// FIXME polypipe
		Buffer buf = Buffer.alloc(9001, RasterPipe.TRIANGLES);

		// copy unsafe renderer state into buffer
		// basically copy from pBase into start of buffer

		// transform data

		// for all polys:
		// -- plane cull
		// -- face cull
		// -- light
		// -- clip
		// -- triangulate

		// feed buffer to raster pipe
		buf.putExtra("OBJ_COLOR0", state.bound_framebuffer.obj_color0);
		rasterpipe.feed(buf);
	}

}
