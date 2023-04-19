// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aspia.desktop.proto

package info.malenkov.aspiabook.proto;

public interface ClientToHostOrBuilder extends
    // @@protoc_insertion_point(interface_extends:info.malenkov.aspiabook.proto.ClientToHost)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.info.malenkov.aspiabook.proto.MouseEvent mouse_event = 1;</code>
   * @return Whether the mouseEvent field is set.
   */
  boolean hasMouseEvent();
  /**
   * <code>.info.malenkov.aspiabook.proto.MouseEvent mouse_event = 1;</code>
   * @return The mouseEvent.
   */
  info.malenkov.aspiabook.proto.MouseEvent getMouseEvent();
  /**
   * <code>.info.malenkov.aspiabook.proto.MouseEvent mouse_event = 1;</code>
   */
  info.malenkov.aspiabook.proto.MouseEventOrBuilder getMouseEventOrBuilder();

  /**
   * <code>.info.malenkov.aspiabook.proto.KeyEvent key_event = 2;</code>
   * @return Whether the keyEvent field is set.
   */
  boolean hasKeyEvent();
  /**
   * <code>.info.malenkov.aspiabook.proto.KeyEvent key_event = 2;</code>
   * @return The keyEvent.
   */
  info.malenkov.aspiabook.proto.KeyEvent getKeyEvent();
  /**
   * <code>.info.malenkov.aspiabook.proto.KeyEvent key_event = 2;</code>
   */
  info.malenkov.aspiabook.proto.KeyEventOrBuilder getKeyEventOrBuilder();

  /**
   * <pre>
   * Field 3 reserved for TouchEvent.
   * </pre>
   *
   * <code>.info.malenkov.aspiabook.proto.TextEvent text_event = 4;</code>
   * @return Whether the textEvent field is set.
   */
  boolean hasTextEvent();
  /**
   * <pre>
   * Field 3 reserved for TouchEvent.
   * </pre>
   *
   * <code>.info.malenkov.aspiabook.proto.TextEvent text_event = 4;</code>
   * @return The textEvent.
   */
  info.malenkov.aspiabook.proto.TextEvent getTextEvent();
  /**
   * <pre>
   * Field 3 reserved for TouchEvent.
   * </pre>
   *
   * <code>.info.malenkov.aspiabook.proto.TextEvent text_event = 4;</code>
   */
  info.malenkov.aspiabook.proto.TextEventOrBuilder getTextEventOrBuilder();

  /**
   * <code>.info.malenkov.aspiabook.proto.ClipboardEvent clipboard_event = 5;</code>
   * @return Whether the clipboardEvent field is set.
   */
  boolean hasClipboardEvent();
  /**
   * <code>.info.malenkov.aspiabook.proto.ClipboardEvent clipboard_event = 5;</code>
   * @return The clipboardEvent.
   */
  info.malenkov.aspiabook.proto.ClipboardEvent getClipboardEvent();
  /**
   * <code>.info.malenkov.aspiabook.proto.ClipboardEvent clipboard_event = 5;</code>
   */
  info.malenkov.aspiabook.proto.ClipboardEventOrBuilder getClipboardEventOrBuilder();

  /**
   * <code>.info.malenkov.aspiabook.proto.DesktopExtension extension = 6;</code>
   * @return Whether the extension field is set.
   */
  boolean hasExtension();
  /**
   * <code>.info.malenkov.aspiabook.proto.DesktopExtension extension = 6;</code>
   * @return The extension.
   */
  info.malenkov.aspiabook.proto.DesktopExtension getExtension();
  /**
   * <code>.info.malenkov.aspiabook.proto.DesktopExtension extension = 6;</code>
   */
  info.malenkov.aspiabook.proto.DesktopExtensionOrBuilder getExtensionOrBuilder();

  /**
   * <code>.info.malenkov.aspiabook.proto.DesktopConfig config = 7;</code>
   * @return Whether the config field is set.
   */
  boolean hasConfig();
  /**
   * <code>.info.malenkov.aspiabook.proto.DesktopConfig config = 7;</code>
   * @return The config.
   */
  info.malenkov.aspiabook.proto.DesktopConfig getConfig();
  /**
   * <code>.info.malenkov.aspiabook.proto.DesktopConfig config = 7;</code>
   */
  info.malenkov.aspiabook.proto.DesktopConfigOrBuilder getConfigOrBuilder();

  /**
   * <code>.info.malenkov.aspiabook.proto.AudioPacket audio_packet = 8;</code>
   * @return Whether the audioPacket field is set.
   */
  boolean hasAudioPacket();
  /**
   * <code>.info.malenkov.aspiabook.proto.AudioPacket audio_packet = 8;</code>
   * @return The audioPacket.
   */
  info.malenkov.aspiabook.proto.AudioPacket getAudioPacket();
  /**
   * <code>.info.malenkov.aspiabook.proto.AudioPacket audio_packet = 8;</code>
   */
  info.malenkov.aspiabook.proto.AudioPacketOrBuilder getAudioPacketOrBuilder();
}