// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aspia.address_book.proto

package info.malenkov.aspiabook.proto;

/**
 * Protobuf type {@code info.malenkov.aspiabook.proto.File}
 */
public final class File extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:info.malenkov.aspiabook.proto.File)
    FileOrBuilder {
private static final long serialVersionUID = 0L;
  // Use File.newBuilder() to construct.
  private File(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private File() {
    encryptionType_ = 0;
    hashingSalt_ = com.google.protobuf.ByteString.EMPTY;
    data_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new File();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return info.malenkov.aspiabook.proto.AspiaAddressBook.internal_static_info_malenkov_aspiabook_proto_File_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return info.malenkov.aspiabook.proto.AspiaAddressBook.internal_static_info_malenkov_aspiabook_proto_File_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            info.malenkov.aspiabook.proto.File.class, info.malenkov.aspiabook.proto.File.Builder.class);
  }

  public static final int ENCRYPTION_TYPE_FIELD_NUMBER = 1;
  private int encryptionType_ = 0;
  /**
   * <pre>
   * Encryption type.
   * </pre>
   *
   * <code>.info.malenkov.aspiabook.proto.EncryptionType encryption_type = 1;</code>
   * @return The enum numeric value on the wire for encryptionType.
   */
  @java.lang.Override public int getEncryptionTypeValue() {
    return encryptionType_;
  }
  /**
   * <pre>
   * Encryption type.
   * </pre>
   *
   * <code>.info.malenkov.aspiabook.proto.EncryptionType encryption_type = 1;</code>
   * @return The encryptionType.
   */
  @java.lang.Override public info.malenkov.aspiabook.proto.EncryptionType getEncryptionType() {
    info.malenkov.aspiabook.proto.EncryptionType result = info.malenkov.aspiabook.proto.EncryptionType.forNumber(encryptionType_);
    return result == null ? info.malenkov.aspiabook.proto.EncryptionType.UNRECOGNIZED : result;
  }

  public static final int HASHING_SALT_FIELD_NUMBER = 3;
  private com.google.protobuf.ByteString hashingSalt_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <pre>
   * If encryption is enabled, contains salt (random data), which are added at each iteration
   * of the hashing to create the key.
   * When the encryption is disabled, the field is not used.
   * </pre>
   *
   * <code>bytes hashing_salt = 3;</code>
   * @return The hashingSalt.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getHashingSalt() {
    return hashingSalt_;
  }

  public static final int DATA_FIELD_NUMBER = 9;
  private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
  /**
   * <pre>
   * If the encryption is enabled, it contains serialized and encrypted |Data|.
   * If the encryption is disabled, it contains a serialized |Data|.
   * </pre>
   *
   * <code>bytes data = 9;</code>
   * @return The data.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getData() {
    return data_;
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
    if (encryptionType_ != info.malenkov.aspiabook.proto.EncryptionType.ENCRYPTION_TYPE_UNKNOWN.getNumber()) {
      output.writeEnum(1, encryptionType_);
    }
    if (!hashingSalt_.isEmpty()) {
      output.writeBytes(3, hashingSalt_);
    }
    if (!data_.isEmpty()) {
      output.writeBytes(9, data_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (encryptionType_ != info.malenkov.aspiabook.proto.EncryptionType.ENCRYPTION_TYPE_UNKNOWN.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, encryptionType_);
    }
    if (!hashingSalt_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, hashingSalt_);
    }
    if (!data_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(9, data_);
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
    if (!(obj instanceof info.malenkov.aspiabook.proto.File)) {
      return super.equals(obj);
    }
    info.malenkov.aspiabook.proto.File other = (info.malenkov.aspiabook.proto.File) obj;

    if (encryptionType_ != other.encryptionType_) return false;
    if (!getHashingSalt()
        .equals(other.getHashingSalt())) return false;
    if (!getData()
        .equals(other.getData())) return false;
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
    hash = (37 * hash) + ENCRYPTION_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + encryptionType_;
    hash = (37 * hash) + HASHING_SALT_FIELD_NUMBER;
    hash = (53 * hash) + getHashingSalt().hashCode();
    hash = (37 * hash) + DATA_FIELD_NUMBER;
    hash = (53 * hash) + getData().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static info.malenkov.aspiabook.proto.File parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.File parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.File parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.File parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.File parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.File parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.File parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.File parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.File parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.File parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.File parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.File parseFrom(
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
  public static Builder newBuilder(info.malenkov.aspiabook.proto.File prototype) {
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
   * Protobuf type {@code info.malenkov.aspiabook.proto.File}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:info.malenkov.aspiabook.proto.File)
      info.malenkov.aspiabook.proto.FileOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return info.malenkov.aspiabook.proto.AspiaAddressBook.internal_static_info_malenkov_aspiabook_proto_File_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return info.malenkov.aspiabook.proto.AspiaAddressBook.internal_static_info_malenkov_aspiabook_proto_File_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              info.malenkov.aspiabook.proto.File.class, info.malenkov.aspiabook.proto.File.Builder.class);
    }

    // Construct using info.malenkov.aspiabook.proto.File.newBuilder()
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
      encryptionType_ = 0;
      hashingSalt_ = com.google.protobuf.ByteString.EMPTY;
      data_ = com.google.protobuf.ByteString.EMPTY;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return info.malenkov.aspiabook.proto.AspiaAddressBook.internal_static_info_malenkov_aspiabook_proto_File_descriptor;
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.File getDefaultInstanceForType() {
      return info.malenkov.aspiabook.proto.File.getDefaultInstance();
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.File build() {
      info.malenkov.aspiabook.proto.File result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.File buildPartial() {
      info.malenkov.aspiabook.proto.File result = new info.malenkov.aspiabook.proto.File(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(info.malenkov.aspiabook.proto.File result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.encryptionType_ = encryptionType_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.hashingSalt_ = hashingSalt_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.data_ = data_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof info.malenkov.aspiabook.proto.File) {
        return mergeFrom((info.malenkov.aspiabook.proto.File)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(info.malenkov.aspiabook.proto.File other) {
      if (other == info.malenkov.aspiabook.proto.File.getDefaultInstance()) return this;
      if (other.encryptionType_ != 0) {
        setEncryptionTypeValue(other.getEncryptionTypeValue());
      }
      if (other.getHashingSalt() != com.google.protobuf.ByteString.EMPTY) {
        setHashingSalt(other.getHashingSalt());
      }
      if (other.getData() != com.google.protobuf.ByteString.EMPTY) {
        setData(other.getData());
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
            case 8: {
              encryptionType_ = input.readEnum();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 26: {
              hashingSalt_ = input.readBytes();
              bitField0_ |= 0x00000002;
              break;
            } // case 26
            case 74: {
              data_ = input.readBytes();
              bitField0_ |= 0x00000004;
              break;
            } // case 74
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

    private int encryptionType_ = 0;
    /**
     * <pre>
     * Encryption type.
     * </pre>
     *
     * <code>.info.malenkov.aspiabook.proto.EncryptionType encryption_type = 1;</code>
     * @return The enum numeric value on the wire for encryptionType.
     */
    @java.lang.Override public int getEncryptionTypeValue() {
      return encryptionType_;
    }
    /**
     * <pre>
     * Encryption type.
     * </pre>
     *
     * <code>.info.malenkov.aspiabook.proto.EncryptionType encryption_type = 1;</code>
     * @param value The enum numeric value on the wire for encryptionType to set.
     * @return This builder for chaining.
     */
    public Builder setEncryptionTypeValue(int value) {
      encryptionType_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Encryption type.
     * </pre>
     *
     * <code>.info.malenkov.aspiabook.proto.EncryptionType encryption_type = 1;</code>
     * @return The encryptionType.
     */
    @java.lang.Override
    public info.malenkov.aspiabook.proto.EncryptionType getEncryptionType() {
      info.malenkov.aspiabook.proto.EncryptionType result = info.malenkov.aspiabook.proto.EncryptionType.forNumber(encryptionType_);
      return result == null ? info.malenkov.aspiabook.proto.EncryptionType.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     * Encryption type.
     * </pre>
     *
     * <code>.info.malenkov.aspiabook.proto.EncryptionType encryption_type = 1;</code>
     * @param value The encryptionType to set.
     * @return This builder for chaining.
     */
    public Builder setEncryptionType(info.malenkov.aspiabook.proto.EncryptionType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      encryptionType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Encryption type.
     * </pre>
     *
     * <code>.info.malenkov.aspiabook.proto.EncryptionType encryption_type = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearEncryptionType() {
      bitField0_ = (bitField0_ & ~0x00000001);
      encryptionType_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString hashingSalt_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     * If encryption is enabled, contains salt (random data), which are added at each iteration
     * of the hashing to create the key.
     * When the encryption is disabled, the field is not used.
     * </pre>
     *
     * <code>bytes hashing_salt = 3;</code>
     * @return The hashingSalt.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getHashingSalt() {
      return hashingSalt_;
    }
    /**
     * <pre>
     * If encryption is enabled, contains salt (random data), which are added at each iteration
     * of the hashing to create the key.
     * When the encryption is disabled, the field is not used.
     * </pre>
     *
     * <code>bytes hashing_salt = 3;</code>
     * @param value The hashingSalt to set.
     * @return This builder for chaining.
     */
    public Builder setHashingSalt(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      hashingSalt_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * If encryption is enabled, contains salt (random data), which are added at each iteration
     * of the hashing to create the key.
     * When the encryption is disabled, the field is not used.
     * </pre>
     *
     * <code>bytes hashing_salt = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearHashingSalt() {
      bitField0_ = (bitField0_ & ~0x00000002);
      hashingSalt_ = getDefaultInstance().getHashingSalt();
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     * If the encryption is enabled, it contains serialized and encrypted |Data|.
     * If the encryption is disabled, it contains a serialized |Data|.
     * </pre>
     *
     * <code>bytes data = 9;</code>
     * @return The data.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getData() {
      return data_;
    }
    /**
     * <pre>
     * If the encryption is enabled, it contains serialized and encrypted |Data|.
     * If the encryption is disabled, it contains a serialized |Data|.
     * </pre>
     *
     * <code>bytes data = 9;</code>
     * @param value The data to set.
     * @return This builder for chaining.
     */
    public Builder setData(com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      data_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * If the encryption is enabled, it contains serialized and encrypted |Data|.
     * If the encryption is disabled, it contains a serialized |Data|.
     * </pre>
     *
     * <code>bytes data = 9;</code>
     * @return This builder for chaining.
     */
    public Builder clearData() {
      bitField0_ = (bitField0_ & ~0x00000004);
      data_ = getDefaultInstance().getData();
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


    // @@protoc_insertion_point(builder_scope:info.malenkov.aspiabook.proto.File)
  }

  // @@protoc_insertion_point(class_scope:info.malenkov.aspiabook.proto.File)
  private static final info.malenkov.aspiabook.proto.File DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new info.malenkov.aspiabook.proto.File();
  }

  public static info.malenkov.aspiabook.proto.File getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<File>
      PARSER = new com.google.protobuf.AbstractParser<File>() {
    @java.lang.Override
    public File parsePartialFrom(
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

  public static com.google.protobuf.Parser<File> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<File> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public info.malenkov.aspiabook.proto.File getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
