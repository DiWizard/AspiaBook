// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aspia.desktop.proto

package info.malenkov.aspiabook.proto;

/**
 * Protobuf type {@code info.malenkov.aspiabook.proto.VideoPacketFormat}
 */
public final class VideoPacketFormat extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:info.malenkov.aspiabook.proto.VideoPacketFormat)
    VideoPacketFormatOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VideoPacketFormat.newBuilder() to construct.
  private VideoPacketFormat(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VideoPacketFormat() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VideoPacketFormat();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return info.malenkov.aspiabook.proto.AspiaDesktop.internal_static_info_malenkov_aspiabook_proto_VideoPacketFormat_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return info.malenkov.aspiabook.proto.AspiaDesktop.internal_static_info_malenkov_aspiabook_proto_VideoPacketFormat_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            info.malenkov.aspiabook.proto.VideoPacketFormat.class, info.malenkov.aspiabook.proto.VideoPacketFormat.Builder.class);
  }

  public static final int VIDEO_RECT_FIELD_NUMBER = 1;
  private info.malenkov.aspiabook.proto.Rect videoRect_;
  /**
   * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
   * @return Whether the videoRect field is set.
   */
  @java.lang.Override
  public boolean hasVideoRect() {
    return videoRect_ != null;
  }
  /**
   * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
   * @return The videoRect.
   */
  @java.lang.Override
  public info.malenkov.aspiabook.proto.Rect getVideoRect() {
    return videoRect_ == null ? info.malenkov.aspiabook.proto.Rect.getDefaultInstance() : videoRect_;
  }
  /**
   * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
   */
  @java.lang.Override
  public info.malenkov.aspiabook.proto.RectOrBuilder getVideoRectOrBuilder() {
    return videoRect_ == null ? info.malenkov.aspiabook.proto.Rect.getDefaultInstance() : videoRect_;
  }

  public static final int PIXEL_FORMAT_FIELD_NUMBER = 2;
  private info.malenkov.aspiabook.proto.PixelFormat pixelFormat_;
  /**
   * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
   * @return Whether the pixelFormat field is set.
   */
  @java.lang.Override
  public boolean hasPixelFormat() {
    return pixelFormat_ != null;
  }
  /**
   * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
   * @return The pixelFormat.
   */
  @java.lang.Override
  public info.malenkov.aspiabook.proto.PixelFormat getPixelFormat() {
    return pixelFormat_ == null ? info.malenkov.aspiabook.proto.PixelFormat.getDefaultInstance() : pixelFormat_;
  }
  /**
   * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
   */
  @java.lang.Override
  public info.malenkov.aspiabook.proto.PixelFormatOrBuilder getPixelFormatOrBuilder() {
    return pixelFormat_ == null ? info.malenkov.aspiabook.proto.PixelFormat.getDefaultInstance() : pixelFormat_;
  }

  public static final int SCREEN_SIZE_FIELD_NUMBER = 3;
  private info.malenkov.aspiabook.proto.Size screenSize_;
  /**
   * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
   * @return Whether the screenSize field is set.
   */
  @java.lang.Override
  public boolean hasScreenSize() {
    return screenSize_ != null;
  }
  /**
   * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
   * @return The screenSize.
   */
  @java.lang.Override
  public info.malenkov.aspiabook.proto.Size getScreenSize() {
    return screenSize_ == null ? info.malenkov.aspiabook.proto.Size.getDefaultInstance() : screenSize_;
  }
  /**
   * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
   */
  @java.lang.Override
  public info.malenkov.aspiabook.proto.SizeOrBuilder getScreenSizeOrBuilder() {
    return screenSize_ == null ? info.malenkov.aspiabook.proto.Size.getDefaultInstance() : screenSize_;
  }

  public static final int CAPTURER_TYPE_FIELD_NUMBER = 4;
  private int capturerType_ = 0;
  /**
   * <code>uint32 capturer_type = 4;</code>
   * @return The capturerType.
   */
  @java.lang.Override
  public int getCapturerType() {
    return capturerType_;
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
    if (videoRect_ != null) {
      output.writeMessage(1, getVideoRect());
    }
    if (pixelFormat_ != null) {
      output.writeMessage(2, getPixelFormat());
    }
    if (screenSize_ != null) {
      output.writeMessage(3, getScreenSize());
    }
    if (capturerType_ != 0) {
      output.writeUInt32(4, capturerType_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (videoRect_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getVideoRect());
    }
    if (pixelFormat_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getPixelFormat());
    }
    if (screenSize_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getScreenSize());
    }
    if (capturerType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(4, capturerType_);
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
    if (!(obj instanceof info.malenkov.aspiabook.proto.VideoPacketFormat)) {
      return super.equals(obj);
    }
    info.malenkov.aspiabook.proto.VideoPacketFormat other = (info.malenkov.aspiabook.proto.VideoPacketFormat) obj;

    if (hasVideoRect() != other.hasVideoRect()) return false;
    if (hasVideoRect()) {
      if (!getVideoRect()
          .equals(other.getVideoRect())) return false;
    }
    if (hasPixelFormat() != other.hasPixelFormat()) return false;
    if (hasPixelFormat()) {
      if (!getPixelFormat()
          .equals(other.getPixelFormat())) return false;
    }
    if (hasScreenSize() != other.hasScreenSize()) return false;
    if (hasScreenSize()) {
      if (!getScreenSize()
          .equals(other.getScreenSize())) return false;
    }
    if (getCapturerType()
        != other.getCapturerType()) return false;
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
    if (hasVideoRect()) {
      hash = (37 * hash) + VIDEO_RECT_FIELD_NUMBER;
      hash = (53 * hash) + getVideoRect().hashCode();
    }
    if (hasPixelFormat()) {
      hash = (37 * hash) + PIXEL_FORMAT_FIELD_NUMBER;
      hash = (53 * hash) + getPixelFormat().hashCode();
    }
    if (hasScreenSize()) {
      hash = (37 * hash) + SCREEN_SIZE_FIELD_NUMBER;
      hash = (53 * hash) + getScreenSize().hashCode();
    }
    hash = (37 * hash) + CAPTURER_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getCapturerType();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static info.malenkov.aspiabook.proto.VideoPacketFormat parseFrom(
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
  public static Builder newBuilder(info.malenkov.aspiabook.proto.VideoPacketFormat prototype) {
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
   * Protobuf type {@code info.malenkov.aspiabook.proto.VideoPacketFormat}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:info.malenkov.aspiabook.proto.VideoPacketFormat)
      info.malenkov.aspiabook.proto.VideoPacketFormatOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return info.malenkov.aspiabook.proto.AspiaDesktop.internal_static_info_malenkov_aspiabook_proto_VideoPacketFormat_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return info.malenkov.aspiabook.proto.AspiaDesktop.internal_static_info_malenkov_aspiabook_proto_VideoPacketFormat_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              info.malenkov.aspiabook.proto.VideoPacketFormat.class, info.malenkov.aspiabook.proto.VideoPacketFormat.Builder.class);
    }

    // Construct using info.malenkov.aspiabook.proto.VideoPacketFormat.newBuilder()
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
      videoRect_ = null;
      if (videoRectBuilder_ != null) {
        videoRectBuilder_.dispose();
        videoRectBuilder_ = null;
      }
      pixelFormat_ = null;
      if (pixelFormatBuilder_ != null) {
        pixelFormatBuilder_.dispose();
        pixelFormatBuilder_ = null;
      }
      screenSize_ = null;
      if (screenSizeBuilder_ != null) {
        screenSizeBuilder_.dispose();
        screenSizeBuilder_ = null;
      }
      capturerType_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return info.malenkov.aspiabook.proto.AspiaDesktop.internal_static_info_malenkov_aspiabook_proto_VideoPacketFormat_descriptor;
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.VideoPacketFormat getDefaultInstanceForType() {
      return info.malenkov.aspiabook.proto.VideoPacketFormat.getDefaultInstance();
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.VideoPacketFormat build() {
      info.malenkov.aspiabook.proto.VideoPacketFormat result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public info.malenkov.aspiabook.proto.VideoPacketFormat buildPartial() {
      info.malenkov.aspiabook.proto.VideoPacketFormat result = new info.malenkov.aspiabook.proto.VideoPacketFormat(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(info.malenkov.aspiabook.proto.VideoPacketFormat result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.videoRect_ = videoRectBuilder_ == null
            ? videoRect_
            : videoRectBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.pixelFormat_ = pixelFormatBuilder_ == null
            ? pixelFormat_
            : pixelFormatBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.screenSize_ = screenSizeBuilder_ == null
            ? screenSize_
            : screenSizeBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.capturerType_ = capturerType_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof info.malenkov.aspiabook.proto.VideoPacketFormat) {
        return mergeFrom((info.malenkov.aspiabook.proto.VideoPacketFormat)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(info.malenkov.aspiabook.proto.VideoPacketFormat other) {
      if (other == info.malenkov.aspiabook.proto.VideoPacketFormat.getDefaultInstance()) return this;
      if (other.hasVideoRect()) {
        mergeVideoRect(other.getVideoRect());
      }
      if (other.hasPixelFormat()) {
        mergePixelFormat(other.getPixelFormat());
      }
      if (other.hasScreenSize()) {
        mergeScreenSize(other.getScreenSize());
      }
      if (other.getCapturerType() != 0) {
        setCapturerType(other.getCapturerType());
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
              input.readMessage(
                  getVideoRectFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getPixelFormatFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              input.readMessage(
                  getScreenSizeFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 32: {
              capturerType_ = input.readUInt32();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
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

    private info.malenkov.aspiabook.proto.Rect videoRect_;
    private com.google.protobuf.SingleFieldBuilderV3<
        info.malenkov.aspiabook.proto.Rect, info.malenkov.aspiabook.proto.Rect.Builder, info.malenkov.aspiabook.proto.RectOrBuilder> videoRectBuilder_;
    /**
     * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
     * @return Whether the videoRect field is set.
     */
    public boolean hasVideoRect() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
     * @return The videoRect.
     */
    public info.malenkov.aspiabook.proto.Rect getVideoRect() {
      if (videoRectBuilder_ == null) {
        return videoRect_ == null ? info.malenkov.aspiabook.proto.Rect.getDefaultInstance() : videoRect_;
      } else {
        return videoRectBuilder_.getMessage();
      }
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
     */
    public Builder setVideoRect(info.malenkov.aspiabook.proto.Rect value) {
      if (videoRectBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        videoRect_ = value;
      } else {
        videoRectBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
     */
    public Builder setVideoRect(
        info.malenkov.aspiabook.proto.Rect.Builder builderForValue) {
      if (videoRectBuilder_ == null) {
        videoRect_ = builderForValue.build();
      } else {
        videoRectBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
     */
    public Builder mergeVideoRect(info.malenkov.aspiabook.proto.Rect value) {
      if (videoRectBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          videoRect_ != null &&
          videoRect_ != info.malenkov.aspiabook.proto.Rect.getDefaultInstance()) {
          getVideoRectBuilder().mergeFrom(value);
        } else {
          videoRect_ = value;
        }
      } else {
        videoRectBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
     */
    public Builder clearVideoRect() {
      bitField0_ = (bitField0_ & ~0x00000001);
      videoRect_ = null;
      if (videoRectBuilder_ != null) {
        videoRectBuilder_.dispose();
        videoRectBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
     */
    public info.malenkov.aspiabook.proto.Rect.Builder getVideoRectBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getVideoRectFieldBuilder().getBuilder();
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
     */
    public info.malenkov.aspiabook.proto.RectOrBuilder getVideoRectOrBuilder() {
      if (videoRectBuilder_ != null) {
        return videoRectBuilder_.getMessageOrBuilder();
      } else {
        return videoRect_ == null ?
            info.malenkov.aspiabook.proto.Rect.getDefaultInstance() : videoRect_;
      }
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Rect video_rect = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        info.malenkov.aspiabook.proto.Rect, info.malenkov.aspiabook.proto.Rect.Builder, info.malenkov.aspiabook.proto.RectOrBuilder> 
        getVideoRectFieldBuilder() {
      if (videoRectBuilder_ == null) {
        videoRectBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            info.malenkov.aspiabook.proto.Rect, info.malenkov.aspiabook.proto.Rect.Builder, info.malenkov.aspiabook.proto.RectOrBuilder>(
                getVideoRect(),
                getParentForChildren(),
                isClean());
        videoRect_ = null;
      }
      return videoRectBuilder_;
    }

    private info.malenkov.aspiabook.proto.PixelFormat pixelFormat_;
    private com.google.protobuf.SingleFieldBuilderV3<
        info.malenkov.aspiabook.proto.PixelFormat, info.malenkov.aspiabook.proto.PixelFormat.Builder, info.malenkov.aspiabook.proto.PixelFormatOrBuilder> pixelFormatBuilder_;
    /**
     * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
     * @return Whether the pixelFormat field is set.
     */
    public boolean hasPixelFormat() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
     * @return The pixelFormat.
     */
    public info.malenkov.aspiabook.proto.PixelFormat getPixelFormat() {
      if (pixelFormatBuilder_ == null) {
        return pixelFormat_ == null ? info.malenkov.aspiabook.proto.PixelFormat.getDefaultInstance() : pixelFormat_;
      } else {
        return pixelFormatBuilder_.getMessage();
      }
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
     */
    public Builder setPixelFormat(info.malenkov.aspiabook.proto.PixelFormat value) {
      if (pixelFormatBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        pixelFormat_ = value;
      } else {
        pixelFormatBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
     */
    public Builder setPixelFormat(
        info.malenkov.aspiabook.proto.PixelFormat.Builder builderForValue) {
      if (pixelFormatBuilder_ == null) {
        pixelFormat_ = builderForValue.build();
      } else {
        pixelFormatBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
     */
    public Builder mergePixelFormat(info.malenkov.aspiabook.proto.PixelFormat value) {
      if (pixelFormatBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          pixelFormat_ != null &&
          pixelFormat_ != info.malenkov.aspiabook.proto.PixelFormat.getDefaultInstance()) {
          getPixelFormatBuilder().mergeFrom(value);
        } else {
          pixelFormat_ = value;
        }
      } else {
        pixelFormatBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
     */
    public Builder clearPixelFormat() {
      bitField0_ = (bitField0_ & ~0x00000002);
      pixelFormat_ = null;
      if (pixelFormatBuilder_ != null) {
        pixelFormatBuilder_.dispose();
        pixelFormatBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
     */
    public info.malenkov.aspiabook.proto.PixelFormat.Builder getPixelFormatBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getPixelFormatFieldBuilder().getBuilder();
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
     */
    public info.malenkov.aspiabook.proto.PixelFormatOrBuilder getPixelFormatOrBuilder() {
      if (pixelFormatBuilder_ != null) {
        return pixelFormatBuilder_.getMessageOrBuilder();
      } else {
        return pixelFormat_ == null ?
            info.malenkov.aspiabook.proto.PixelFormat.getDefaultInstance() : pixelFormat_;
      }
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.PixelFormat pixel_format = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        info.malenkov.aspiabook.proto.PixelFormat, info.malenkov.aspiabook.proto.PixelFormat.Builder, info.malenkov.aspiabook.proto.PixelFormatOrBuilder> 
        getPixelFormatFieldBuilder() {
      if (pixelFormatBuilder_ == null) {
        pixelFormatBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            info.malenkov.aspiabook.proto.PixelFormat, info.malenkov.aspiabook.proto.PixelFormat.Builder, info.malenkov.aspiabook.proto.PixelFormatOrBuilder>(
                getPixelFormat(),
                getParentForChildren(),
                isClean());
        pixelFormat_ = null;
      }
      return pixelFormatBuilder_;
    }

    private info.malenkov.aspiabook.proto.Size screenSize_;
    private com.google.protobuf.SingleFieldBuilderV3<
        info.malenkov.aspiabook.proto.Size, info.malenkov.aspiabook.proto.Size.Builder, info.malenkov.aspiabook.proto.SizeOrBuilder> screenSizeBuilder_;
    /**
     * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
     * @return Whether the screenSize field is set.
     */
    public boolean hasScreenSize() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
     * @return The screenSize.
     */
    public info.malenkov.aspiabook.proto.Size getScreenSize() {
      if (screenSizeBuilder_ == null) {
        return screenSize_ == null ? info.malenkov.aspiabook.proto.Size.getDefaultInstance() : screenSize_;
      } else {
        return screenSizeBuilder_.getMessage();
      }
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
     */
    public Builder setScreenSize(info.malenkov.aspiabook.proto.Size value) {
      if (screenSizeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        screenSize_ = value;
      } else {
        screenSizeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
     */
    public Builder setScreenSize(
        info.malenkov.aspiabook.proto.Size.Builder builderForValue) {
      if (screenSizeBuilder_ == null) {
        screenSize_ = builderForValue.build();
      } else {
        screenSizeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
     */
    public Builder mergeScreenSize(info.malenkov.aspiabook.proto.Size value) {
      if (screenSizeBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
          screenSize_ != null &&
          screenSize_ != info.malenkov.aspiabook.proto.Size.getDefaultInstance()) {
          getScreenSizeBuilder().mergeFrom(value);
        } else {
          screenSize_ = value;
        }
      } else {
        screenSizeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
     */
    public Builder clearScreenSize() {
      bitField0_ = (bitField0_ & ~0x00000004);
      screenSize_ = null;
      if (screenSizeBuilder_ != null) {
        screenSizeBuilder_.dispose();
        screenSizeBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
     */
    public info.malenkov.aspiabook.proto.Size.Builder getScreenSizeBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getScreenSizeFieldBuilder().getBuilder();
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
     */
    public info.malenkov.aspiabook.proto.SizeOrBuilder getScreenSizeOrBuilder() {
      if (screenSizeBuilder_ != null) {
        return screenSizeBuilder_.getMessageOrBuilder();
      } else {
        return screenSize_ == null ?
            info.malenkov.aspiabook.proto.Size.getDefaultInstance() : screenSize_;
      }
    }
    /**
     * <code>.info.malenkov.aspiabook.proto.Size screen_size = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        info.malenkov.aspiabook.proto.Size, info.malenkov.aspiabook.proto.Size.Builder, info.malenkov.aspiabook.proto.SizeOrBuilder> 
        getScreenSizeFieldBuilder() {
      if (screenSizeBuilder_ == null) {
        screenSizeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            info.malenkov.aspiabook.proto.Size, info.malenkov.aspiabook.proto.Size.Builder, info.malenkov.aspiabook.proto.SizeOrBuilder>(
                getScreenSize(),
                getParentForChildren(),
                isClean());
        screenSize_ = null;
      }
      return screenSizeBuilder_;
    }

    private int capturerType_ ;
    /**
     * <code>uint32 capturer_type = 4;</code>
     * @return The capturerType.
     */
    @java.lang.Override
    public int getCapturerType() {
      return capturerType_;
    }
    /**
     * <code>uint32 capturer_type = 4;</code>
     * @param value The capturerType to set.
     * @return This builder for chaining.
     */
    public Builder setCapturerType(int value) {

      capturerType_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 capturer_type = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearCapturerType() {
      bitField0_ = (bitField0_ & ~0x00000008);
      capturerType_ = 0;
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


    // @@protoc_insertion_point(builder_scope:info.malenkov.aspiabook.proto.VideoPacketFormat)
  }

  // @@protoc_insertion_point(class_scope:info.malenkov.aspiabook.proto.VideoPacketFormat)
  private static final info.malenkov.aspiabook.proto.VideoPacketFormat DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new info.malenkov.aspiabook.proto.VideoPacketFormat();
  }

  public static info.malenkov.aspiabook.proto.VideoPacketFormat getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VideoPacketFormat>
      PARSER = new com.google.protobuf.AbstractParser<VideoPacketFormat>() {
    @java.lang.Override
    public VideoPacketFormat parsePartialFrom(
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

  public static com.google.protobuf.Parser<VideoPacketFormat> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VideoPacketFormat> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public info.malenkov.aspiabook.proto.VideoPacketFormat getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

