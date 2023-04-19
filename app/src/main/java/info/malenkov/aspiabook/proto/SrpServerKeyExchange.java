// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aspia.key_exchange.proto

package info.malenkov.aspiabook.proto;

/**
 * <pre>
 * Server to client.
 * </pre>
 *
 * Protobuf type {@code info.malenkov.aspiabook.proto.SrpServerKeyExchange}
 */
public final class SrpServerKeyExchange extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:info.malenkov.aspiabook.proto.SrpServerKeyExchange)
    SrpServerKeyExchangeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SrpServerKeyExchange.newBuilder() to construct.
  private SrpServerKeyExchange(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SrpServerKeyExchange() {
    number_ = com.google.protobuf.ByteString.EMPTY;
    generator_ = com.google.protobuf.ByteString.EMPTY;
    salt_ = com.google.protobuf.ByteString.EMPTY;
    b_ = com.google.protobuf.ByteString.EMPTY;
    iv_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SrpServerKeyExchange();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return info.malenkov.aspiabook.proto.AspiaKeyExchange.internal_static_info_malenkov_aspiabook_proto_SrpServerKeyExchange_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return info.malenkov.aspiabook.proto.AspiaKeyExchange.internal_static_info_malenkov_aspiabook_proto_SrpServerKeyExchange_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            info.malenkov.aspiabook.proto.SrpServerKeyExchange.class, info.malenkov.aspiabook.proto.SrpServerKeyExchange.Builder.class);
  }

  public static final int NUMBER_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString number_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <code>bytes number = 1;</code>
   * @return The number.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getNumber() {
    return number_;
  }

  public static final int GENERATOR_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString generator_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <code>bytes generator = 2;</code>
   * @return The generator.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getGenerator() {
    return generator_;
  }

  public static final int SALT_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString salt_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <code>bytes salt = 3;</code>
   * @return The salt.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getSalt() {
    return salt_;
  }

  public static final int B_FIELD_NUMBER = 4;
  private com.google.protobuf.ByteString b_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <code>bytes B = 4;</code>
   * @return The b.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getB() {
    return b_;
  }

  public static final int IV_FIELD_NUMBER = 5;
  private com.google.protobuf.ByteString iv_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <code>bytes iv = 5;</code>
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
    if (!number_.isEmpty()) {
      output.writeBytes(1, number_);
    }
    if (!generator_.isEmpty()) {
      output.writeBytes(2, generator_);
    }
    if (!salt_.isEmpty()) {
      output.writeBytes(3, salt_);
    }
    if (!b_.isEmpty()) {
      output.writeBytes(4, b_);
    }
    if (!iv_.isEmpty()) {
      output.writeBytes(5, iv_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!number_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, number_);
    }
    if (!generator_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, generator_);
    }
    if (!salt_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, salt_);
    }
    if (!b_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(4, b_);
    }
    if (!iv_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(5, iv_);
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
    if (!(obj instanceof info.malenkov.aspiabook.proto.SrpServerKeyExchange)) {
      return super.equals(obj);
    }
    info.malenkov.aspiabook.proto.SrpServerKeyExchange other = (info.malenkov.aspiabook.proto.SrpServerKeyExchange) obj;

    if (!getNumber()
        .equals(other.getNumber())) return false;
    if (!getGenerator()
        .equals(other.getGenerator())) return false;
    if (!getSalt()
        .equals(other.getSalt())) return false;
    if (!getB()
        .equals(other.getB())) return false;
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
    hash = (37 * hash) + NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getNumber().hashCode();
    hash = (37 * hash) + GENERATOR_FIELD_NUMBER;
    hash = (53 * hash) + getGenerator().hashCode();
    hash = (37 * hash) + SALT_FIELD_NUMBER;
    hash = (53 * hash) + getSalt().hashCode();
    hash = (37 * hash) + B_FIELD_NUMBER;
    hash = (53 * hash) + getB().hashCode();
    hash = (37 * hash) + IV_FIELD_NUMBER;
    hash = (53 * hash) + getIv().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange parseFrom(
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
  public static Builder newBuilder(info.malenkov.aspiabook.proto.SrpServerKeyExchange prototype) {
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
   * Server to client.
   * </pre>
   *
   * Protobuf type {@code info.malenkov.aspiabook.proto.SrpServerKeyExchange}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:info.malenkov.aspiabook.proto.SrpServerKeyExchange)
      info.malenkov.aspiabook.proto.SrpServerKeyExchangeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return info.malenkov.aspiabook.proto.AspiaKeyExchange.internal_static_info_malenkov_aspiabook_proto_SrpServerKeyExchange_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return info.malenkov.aspiabook.proto.AspiaKeyExchange.internal_static_info_malenkov_aspiabook_proto_SrpServerKeyExchange_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              info.malenkov.aspiabook.proto.SrpServerKeyExchange.class, info.malenkov.aspiabook.proto.SrpServerKeyExchange.Builder.class);
    }

    // Construct using info.malenkov.aspiabook.proto.SrpServerKeyExchange.newBuilder()
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
      number_ = com.google.protobuf.ByteString.EMPTY;
      generator_ = com.google.protobuf.ByteString.EMPTY;
      salt_ = com.google.protobuf.ByteString.EMPTY;
      b_ = com.google.protobuf.ByteString.EMPTY;
      iv_ = com.google.protobuf.ByteString.EMPTY;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return info.malenkov.aspiabook.proto.AspiaKeyExchange.internal_static_info_malenkov_aspiabook_proto_SrpServerKeyExchange_descriptor;
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.SrpServerKeyExchange getDefaultInstanceForType() {
      return info.malenkov.aspiabook.proto.SrpServerKeyExchange.getDefaultInstance();
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.SrpServerKeyExchange build() {
      info.malenkov.aspiabook.proto.SrpServerKeyExchange result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.SrpServerKeyExchange buildPartial() {
      info.malenkov.aspiabook.proto.SrpServerKeyExchange result = new info.malenkov.aspiabook.proto.SrpServerKeyExchange(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(info.malenkov.aspiabook.proto.SrpServerKeyExchange result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.number_ = number_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.generator_ = generator_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.salt_ = salt_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.b_ = b_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.iv_ = iv_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof info.malenkov.aspiabook.proto.SrpServerKeyExchange) {
        return mergeFrom((info.malenkov.aspiabook.proto.SrpServerKeyExchange)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(info.malenkov.aspiabook.proto.SrpServerKeyExchange other) {
      if (other == info.malenkov.aspiabook.proto.SrpServerKeyExchange.getDefaultInstance()) return this;
      if (other.getNumber() != com.google.protobuf.ByteString.EMPTY) {
        setNumber(other.getNumber());
      }
      if (other.getGenerator() != com.google.protobuf.ByteString.EMPTY) {
        setGenerator(other.getGenerator());
      }
      if (other.getSalt() != com.google.protobuf.ByteString.EMPTY) {
        setSalt(other.getSalt());
      }
      if (other.getB() != com.google.protobuf.ByteString.EMPTY) {
        setB(other.getB());
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
              number_ = input.readBytes();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              generator_ = input.readBytes();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              salt_ = input.readBytes();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              b_ = input.readBytes();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            case 42: {
              iv_ = input.readBytes();
              bitField0_ |= 0x00000010;
              break;
            } // case 42
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

    private com.google.protobuf.ByteString number_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes number = 1;</code>
     * @return The number.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getNumber() {
      return number_;
    }
    /**
     * <code>bytes number = 1;</code>
     * @param value The number to set.
     * @return This builder for chaining.
     */
    public Builder setNumber(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      number_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>bytes number = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearNumber() {
      bitField0_ = (bitField0_ & ~0x00000001);
      number_ = getDefaultInstance().getNumber();
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString generator_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes generator = 2;</code>
     * @return The generator.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getGenerator() {
      return generator_;
    }
    /**
     * <code>bytes generator = 2;</code>
     * @param value The generator to set.
     * @return This builder for chaining.
     */
    public Builder setGenerator(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      generator_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bytes generator = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearGenerator() {
      bitField0_ = (bitField0_ & ~0x00000002);
      generator_ = getDefaultInstance().getGenerator();
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString salt_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes salt = 3;</code>
     * @return The salt.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getSalt() {
      return salt_;
    }
    /**
     * <code>bytes salt = 3;</code>
     * @param value The salt to set.
     * @return This builder for chaining.
     */
    public Builder setSalt(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      salt_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>bytes salt = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearSalt() {
      bitField0_ = (bitField0_ & ~0x00000004);
      salt_ = getDefaultInstance().getSalt();
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString b_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes B = 4;</code>
     * @return The b.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getB() {
      return b_;
    }
    /**
     * <code>bytes B = 4;</code>
     * @param value The b to set.
     * @return This builder for chaining.
     */
    public Builder setB(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      b_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>bytes B = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearB() {
      bitField0_ = (bitField0_ & ~0x00000008);
      b_ = getDefaultInstance().getB();
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString iv_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes iv = 5;</code>
     * @return The iv.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getIv() {
      return iv_;
    }
    /**
     * <code>bytes iv = 5;</code>
     * @param value The iv to set.
     * @return This builder for chaining.
     */
    public Builder setIv(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      iv_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>bytes iv = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearIv() {
      bitField0_ = (bitField0_ & ~0x00000010);
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


    // @@protoc_insertion_point(builder_scope:info.malenkov.aspiabook.proto.SrpServerKeyExchange)
  }

  // @@protoc_insertion_point(class_scope:info.malenkov.aspiabook.proto.SrpServerKeyExchange)
  private static final info.malenkov.aspiabook.proto.SrpServerKeyExchange DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new info.malenkov.aspiabook.proto.SrpServerKeyExchange();
  }

  public static info.malenkov.aspiabook.proto.SrpServerKeyExchange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SrpServerKeyExchange>
      PARSER = new com.google.protobuf.AbstractParser<SrpServerKeyExchange>() {
    @java.lang.Override
    public SrpServerKeyExchange parsePartialFrom(
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

  public static com.google.protobuf.Parser<SrpServerKeyExchange> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SrpServerKeyExchange> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public info.malenkov.aspiabook.proto.SrpServerKeyExchange getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
