// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aspia.key_exchange.proto

package info.malenkov.aspiabook.proto;

/**
 * Protobuf enum {@code info.malenkov.aspiabook.proto.Identify}
 */
public enum Identify
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>IDENTIFY_SRP = 0;</code>
   */
  IDENTIFY_SRP(0),
  /**
   * <code>IDENTIFY_ANONYMOUS = 1;</code>
   */
  IDENTIFY_ANONYMOUS(1),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>IDENTIFY_SRP = 0;</code>
   */
  public static final int IDENTIFY_SRP_VALUE = 0;
  /**
   * <code>IDENTIFY_ANONYMOUS = 1;</code>
   */
  public static final int IDENTIFY_ANONYMOUS_VALUE = 1;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Identify valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Identify forNumber(int value) {
    switch (value) {
      case 0: return IDENTIFY_SRP;
      case 1: return IDENTIFY_ANONYMOUS;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Identify>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Identify> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Identify>() {
          public Identify findValueByNumber(int number) {
            return Identify.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return info.malenkov.aspiabook.proto.AspiaKeyExchange.getDescriptor().getEnumTypes().get(0);
  }

  private static final Identify[] VALUES = values();

  public static Identify valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Identify(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:info.malenkov.aspiabook.proto.Identify)
}

