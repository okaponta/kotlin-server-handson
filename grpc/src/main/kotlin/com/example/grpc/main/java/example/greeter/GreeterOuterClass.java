// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: greeter.proto

package example.greeter;

public final class GreeterOuterClass {
  private GreeterOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_example_greeter_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_example_greeter_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_example_greeter_HelloResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_example_greeter_HelloResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rgreeter.proto\022\017example.greeter\"\034\n\014Hell" +
      "oRequest\022\014\n\004name\030\001 \001(\t\"\035\n\rHelloResponse\022" +
      "\014\n\004text\030\001 \001(\t2Q\n\007Greeter\022F\n\005Hello\022\035.exam" +
      "ple.greeter.HelloRequest\032\036.example.greet" +
      "er.HelloResponseB\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_example_greeter_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_example_greeter_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_example_greeter_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_example_greeter_HelloResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_example_greeter_HelloResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_example_greeter_HelloResponse_descriptor,
        new java.lang.String[] { "Text", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
