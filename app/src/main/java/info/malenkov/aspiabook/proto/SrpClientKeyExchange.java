// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aspia.key_exchange.proto

package info.malenkov.aspiabook.proto;

/**
 * <pre>
 * Client to server.
 * </pre>
 *
 * Protobuf type {@code info.malenkov.aspiabook.proto.SrpClientKeyExchange}
 */
public final class SrpClientKeyExchange extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:info.malenkov.aspiabook.proto.SrpClientKeyExchange)
    SrpClientKeyExchangeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SrpClientKeyExchange.newBuilder() to construct.
  private SrpClientKeyExchange(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SrpClientKeyExchange() {
    a_ = com.google.protobuf.ByteString.EMPTY;
    iv_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SrpClientKeyExchange();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return info.malenkov.aspiabook.proto.AspiaKeyExchange.internal_static_info_malenkov_aspiabook_proto_SrpClientKeyExchange_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return info.malenkov.aspiabook.proto.AspiaKeyExchange.internal_static_info_malenkov_aspiabook_proto_SrpClientKeyExchange_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            info.malenkov.aspiabook.proto.SrpClientKeyExchange.class, info.malenkov.aspiabook.proto.SrpClientKeyExchange.Builder.class);
  }

  public static final int A_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString a_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <code>bytes A = 1;</code>
   * @return The a.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getA() {
    return a_;
  }

  public static final int IV_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString iv_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <code>bytes iv = 2;</code>
   * @return The iv.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getIv() {
    return iv_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!a_.isEmpty()) {
      output.writeBytes(1, a_);
    }
    if (!iv_.isEmpty()) {
      output.writeBytes(2, iv_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!a_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, a_);
    }
    if (!iv_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, iv_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof info.malenkov.aspiabook.proto.SrpClientKeyExchange)) {
      return super.equals(obj);
    }
    info.malenkov.aspiabook.proto.SrpClientKeyExchange other = (info.malenkov.aspiabook.proto.SrpClientKeyExchange) obj;

    if (!getA()
        .equals(other.getA())) return false;
    if (!getIv()
        .equals(other.getIv())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + A_FIELD_NUMBER;
    hash = (53 * hash) + getA().hashCode();
    hash = (37 * hash) + IV_FIELD_NUMBER;
    hash = (53 * hash) + getIv().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(info.malenkov.aspiabook.proto.SrpClientKeyExchange prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Client to server.
   * </pre>
   *
   * Protobuf type {@code info.malenkov.aspiabook.proto.SrpClientKeyExchange}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:info.malenkov.aspiabook.proto.SrpClientKeyExchange)
      info.malenkov.aspiabook.proto.SrpClientKeyExchangeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return info.malenkov.aspiabook.proto.AspiaKeyExchange.internal_static_info_malenkov_aspiabook_proto_SrpClientKeyExchange_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return info.malenkov.aspiabook.proto.AspiaKeyExchange.internal_static_info_malenkov_aspiabook_proto_SrpClientKeyExchange_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              info.malenkov.aspiabook.proto.SrpClientKeyExchange.class, info.malenkov.aspiabook.proto.SrpClientKeyExchange.Builder.class);
    }

    // Construct using info.malenkov.aspiabook.proto.SrpClientKeyExchange.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      a_ = com.google.protobuf.ByteString.EMPTY;
      iv_ = com.google.protobuf.ByteString.EMPTY;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return info.malenkov.aspiabook.proto.AspiaKeyExchange.internal_static_info_malenkov_aspiabook_proto_SrpClientKeyExchange_descriptor;
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.SrpClientKeyExchange getDefaultInstanceForType() {
      return info.malenkov.aspiabook.proto.SrpClientKeyExchange.getDefaultInstance();
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.SrpClientKeyExchange build() {
      info.malenkov.aspiabook.proto.SrpClientKeyExchange result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.SrpClientKeyExchange buildPartial() {
      info.malenkov.aspiabook.proto.SrpClientKeyExchange result = new info.malenkov.aspiabook.proto.SrpClientKeyExchange(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(info.malenkov.aspiabook.proto.SrpClientKeyExchange result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.a_ = a_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.iv_ = iv_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof info.malenkov.aspiabook.proto.SrpClientKeyExchange) {
        return mergeFrom((info.malenkov.aspiabook.proto.SrpClientKeyExchange)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(info.malenkov.aspiabook.proto.SrpClientKeyExchange other) {
      if (other == info.malenkov.aspiabook.proto.SrpClientKeyExchange.getDefaultInstance()) return this;
      if (other.getA() != com.google.protobuf.ByteString.EMPTY) {
        setA(other.getA());
      }
      if (other.getIv() != com.google.protobuf.ByteString.EMPTY) {
        setIv(other.getIv());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              a_ = input.readBytes();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              iv_ = input.readBytes();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.ByteString a_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes A = 1;</code>
     * @return The a.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getA() {
      return a_;
    }
    /**
     * <code>bytes A = 1;</code>
     * @param value The a to set.
     * @return This builder for chaining.
     */
    public Builder setA(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      a_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>bytes A = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearA() {
      bitField0_ = (bitField0_ & ~0x00000001);
      a_ = getDefaultInstance().getA();
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString iv_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes iv = 2;</code>
     * @return The iv.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getIv() {
      return iv_;
    }
    /**
     * <code>bytes iv = 2;</code>
     * @param value The iv to set.
     * @return This builder for chaining.
     */
    public Builder setIv(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      iv_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bytes iv = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearIv() {
      bitField0_ = (bitField0_ & ~0x00000002);
      iv_ = getDefaultInstance().getIv();
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:info.malenkov.aspiabook.proto.SrpClientKeyExchange)
  }

  // @@protoc_insertion_point(class_scope:info.malenkov.aspiabook.proto.SrpClientKeyExchange)
  private static final info.malenkov.aspiabook.proto.SrpClientKeyExchange DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new info.malenkov.aspiabook.proto.SrpClientKeyExchange();
  }

  public static info.malenkov.aspiabook.proto.SrpClientKeyExchange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SrpClientKeyExchange>
      PARSER = new com.google.protobuf.AbstractParser<SrpClientKeyExchange>() {
    @java.lang.Override
    public SrpClientKeyExchange parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<SrpClientKeyExchange> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SrpClientKeyExchange> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public info.malenkov.aspiabook.proto.SrpClientKeyExchange getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

