// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aspia.key_exchange.proto

package info.malenkov.aspiabook.proto;

public interface ServerHelloOrBuilder extends
    // @@protoc_insertion_point(interface_extends:info.malenkov.aspiabook.proto.ServerHello)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.info.malenkov.aspiabook.proto.Encryption encryption = 1;</code>
   * @return The enum numeric value on the wire for encryption.
   */
  int getEncryptionValue();
  /**
   * <code>.info.malenkov.aspiabook.proto.Encryption encryption = 1;</code>
   * @return The encryption.
   */
  info.malenkov.aspiabook.proto.Encryption getEncryption();

  /**
   * <code>bytes iv = 2;</code>
   * @return The iv.
   */
  com.google.protobuf.ByteString getIv();
}