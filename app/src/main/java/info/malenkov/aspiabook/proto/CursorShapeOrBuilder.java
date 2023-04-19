// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aspia.desktop.proto

package info.malenkov.aspiabook.proto;

public interface CursorShapeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:info.malenkov.aspiabook.proto.CursorShape)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * We use only the first byte in this field.
   * If bit 7 is set to 1, then bits 0-4 contain the cursor index in the cache.
   * If bit 7 is not set, then the cursor image is received.
   * If bit 6 is set to 1, then the command to reset the contents of the cache
   * is received, and bits 0-4 contain a new cache size.
   * Bit 5 is reserved.
   * </pre>
   *
   * <code>uint32 flags = 1;</code>
   * @return The flags.
   */
  int getFlags();

  /**
   * <pre>
   * Width, height (in screen pixels) of the cursor.
   * </pre>
   *
   * <code>int32 width = 2;</code>
   * @return The width.
   */
  int getWidth();

  /**
   * <code>int32 height = 3;</code>
   * @return The height.
   */
  int getHeight();

  /**
   * <pre>
   * X,Y coordinates (relative to upper-left corner) of the cursor hotspot.
   * </pre>
   *
   * <code>int32 hotspot_x = 4;</code>
   * @return The hotspotX.
   */
  int getHotspotX();

  /**
   * <code>int32 hotspot_y = 5;</code>
   * @return The hotspotY.
   */
  int getHotspotY();

  /**
   * <pre>
   * Cursor pixmap data in 32-bit BGRA format compressed with Zstd.
   * </pre>
   *
   * <code>bytes data = 6;</code>
   * @return The data.
   */
  com.google.protobuf.ByteString getData();

  /**
   * <pre>
   * Screen DPI for current cursor.
   * </pre>
   *
   * <code>int32 dpi_x = 7;</code>
   * @return The dpiX.
   */
  int getDpiX();

  /**
   * <code>int32 dpi_y = 8;</code>
   * @return The dpiY.
   */
  int getDpiY();
}
