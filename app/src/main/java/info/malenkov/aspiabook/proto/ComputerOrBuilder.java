// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aspia.address_book.proto

package info.malenkov.aspiabook.proto;

public interface ComputerOrBuilder extends
    // @@protoc_insertion_point(interface_extends:info.malenkov.aspiabook.proto.Computer)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 create_time = 1;</code>
   * @return The createTime.
   */
  long getCreateTime();

  /**
   * <pre>
   * Field 3 not used (deprecated).
   * </pre>
   *
   * <code>int64 modify_time = 2;</code>
   * @return The modifyTime.
   */
  long getModifyTime();

  /**
   * <code>string name = 4;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 4;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string comment = 5;</code>
   * @return The comment.
   */
  java.lang.String getComment();
  /**
   * <code>string comment = 5;</code>
   * @return The bytes for comment.
   */
  com.google.protobuf.ByteString
      getCommentBytes();

  /**
   * <code>string address = 6;</code>
   * @return The address.
   */
  java.lang.String getAddress();
  /**
   * <code>string address = 6;</code>
   * @return The bytes for address.
   */
  com.google.protobuf.ByteString
      getAddressBytes();

  /**
   * <code>uint32 port = 7;</code>
   * @return The port.
   */
  int getPort();

  /**
   * <code>string username = 8;</code>
   * @return The username.
   */
  java.lang.String getUsername();
  /**
   * <code>string username = 8;</code>
   * @return The bytes for username.
   */
  com.google.protobuf.ByteString
      getUsernameBytes();

  /**
   * <code>string password = 9;</code>
   * @return The password.
   */
  java.lang.String getPassword();
  /**
   * <code>string password = 9;</code>
   * @return The bytes for password.
   */
  com.google.protobuf.ByteString
      getPasswordBytes();

  /**
   * <code>.info.malenkov.aspiabook.proto.InheritConfig inherit = 12;</code>
   * @return Whether the inherit field is set.
   */
  boolean hasInherit();
  /**
   * <code>.info.malenkov.aspiabook.proto.InheritConfig inherit = 12;</code>
   * @return The inherit.
   */
  info.malenkov.aspiabook.proto.InheritConfig getInherit();
  /**
   * <code>.info.malenkov.aspiabook.proto.InheritConfig inherit = 12;</code>
   */
  info.malenkov.aspiabook.proto.InheritConfigOrBuilder getInheritOrBuilder();

  /**
   * <pre>
   * Session configurations.
   * </pre>
   *
   * <code>.info.malenkov.aspiabook.proto.SessionType session_type = 16;</code>
   * @return The enum numeric value on the wire for sessionType.
   */
  int getSessionTypeValue();
  /**
   * <pre>
   * Session configurations.
   * </pre>
   *
   * <code>.info.malenkov.aspiabook.proto.SessionType session_type = 16;</code>
   * @return The sessionType.
   */
  info.malenkov.aspiabook.proto.SessionType getSessionType();

  /**
   * <code>.info.malenkov.aspiabook.proto.SessionConfig session_config = 17;</code>
   * @return Whether the sessionConfig field is set.
   */
  boolean hasSessionConfig();
  /**
   * <code>.info.malenkov.aspiabook.proto.SessionConfig session_config = 17;</code>
   * @return The sessionConfig.
   */
  info.malenkov.aspiabook.proto.SessionConfig getSessionConfig();
  /**
   * <code>.info.malenkov.aspiabook.proto.SessionConfig session_config = 17;</code>
   */
  info.malenkov.aspiabook.proto.SessionConfigOrBuilder getSessionConfigOrBuilder();
}
