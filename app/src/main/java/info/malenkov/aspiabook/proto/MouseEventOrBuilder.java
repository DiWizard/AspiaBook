// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aspia.desktop.proto

package info.malenkov.aspiabook.proto;

public interface MouseEventOrBuilder extends
    // @@protoc_insertion_point(interface_extends:info.malenkov.aspiabook.proto.MouseEvent)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Button mask.
   * </pre>
   *
   * <code>uint32 mask = 1;</code>
   * @return The mask.
   */
  int getMask();

  /**
   * <pre>
   * x position.
   * </pre>
   *
   * <code>int32 x = 2;</code>
   * @return The x.
   */
  int getX();

  /**
   * <pre>
   * y position.
   * </pre>
   *
   * <code>int32 y = 3;</code>
   * @return The y.
   */
  int getY();
}