// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aspia.desktop.proto

package info.malenkov.aspiabook.proto;

public interface DesktopConfigRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:info.malenkov.aspiabook.proto.DesktopConfigRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string extensions = 1;</code>
   * @return The extensions.
   */
  java.lang.String getExtensions();
  /**
   * <code>string extensions = 1;</code>
   * @return The bytes for extensions.
   */
  com.google.protobuf.ByteString
      getExtensionsBytes();

  /**
   * <code>uint32 video_encodings = 2;</code>
   * @return The videoEncodings.
   */
  int getVideoEncodings();

  /**
   * <code>uint32 audio_encodings = 3;</code>
   * @return The audioEncodings.
   */
  int getAudioEncodings();
}
