package cn.hua.netty.grpc_example;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: animal.proto")
public final class AnimalServiceGrpc {

  private AnimalServiceGrpc() {}

  public static final String SERVICE_NAME = "cn.hua.netty.grpc_example.AnimalService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetRealNameByUserNameMethod()} instead. 
  public static final io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.MyRequest,
      cn.hua.netty.grpc_example.MyResponse> METHOD_GET_REAL_NAME_BY_USER_NAME = getGetRealNameByUserNameMethodHelper();

  private static volatile io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.MyRequest,
      cn.hua.netty.grpc_example.MyResponse> getGetRealNameByUserNameMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.MyRequest,
      cn.hua.netty.grpc_example.MyResponse> getGetRealNameByUserNameMethod() {
    return getGetRealNameByUserNameMethodHelper();
  }

  private static io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.MyRequest,
      cn.hua.netty.grpc_example.MyResponse> getGetRealNameByUserNameMethodHelper() {
    io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.MyRequest, cn.hua.netty.grpc_example.MyResponse> getGetRealNameByUserNameMethod;
    if ((getGetRealNameByUserNameMethod = AnimalServiceGrpc.getGetRealNameByUserNameMethod) == null) {
      synchronized (AnimalServiceGrpc.class) {
        if ((getGetRealNameByUserNameMethod = AnimalServiceGrpc.getGetRealNameByUserNameMethod) == null) {
          AnimalServiceGrpc.getGetRealNameByUserNameMethod = getGetRealNameByUserNameMethod = 
              io.grpc.MethodDescriptor.<cn.hua.netty.grpc_example.MyRequest, cn.hua.netty.grpc_example.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cn.hua.netty.grpc_example.AnimalService", "getRealNameByUserName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hua.netty.grpc_example.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hua.netty.grpc_example.MyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AnimalServiceMethodDescriptorSupplier("getRealNameByUserName"))
                  .build();
          }
        }
     }
     return getGetRealNameByUserNameMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAnimalsByAgeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.AnimalRequest,
      cn.hua.netty.grpc_example.AnimalResponse> METHOD_GET_ANIMALS_BY_AGE = getGetAnimalsByAgeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.AnimalRequest,
      cn.hua.netty.grpc_example.AnimalResponse> getGetAnimalsByAgeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.AnimalRequest,
      cn.hua.netty.grpc_example.AnimalResponse> getGetAnimalsByAgeMethod() {
    return getGetAnimalsByAgeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.AnimalRequest,
      cn.hua.netty.grpc_example.AnimalResponse> getGetAnimalsByAgeMethodHelper() {
    io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.AnimalRequest, cn.hua.netty.grpc_example.AnimalResponse> getGetAnimalsByAgeMethod;
    if ((getGetAnimalsByAgeMethod = AnimalServiceGrpc.getGetAnimalsByAgeMethod) == null) {
      synchronized (AnimalServiceGrpc.class) {
        if ((getGetAnimalsByAgeMethod = AnimalServiceGrpc.getGetAnimalsByAgeMethod) == null) {
          AnimalServiceGrpc.getGetAnimalsByAgeMethod = getGetAnimalsByAgeMethod = 
              io.grpc.MethodDescriptor.<cn.hua.netty.grpc_example.AnimalRequest, cn.hua.netty.grpc_example.AnimalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "cn.hua.netty.grpc_example.AnimalService", "getAnimalsByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hua.netty.grpc_example.AnimalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hua.netty.grpc_example.AnimalResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AnimalServiceMethodDescriptorSupplier("getAnimalsByAge"))
                  .build();
          }
        }
     }
     return getGetAnimalsByAgeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAnimalResponseListByAgesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.AnimalRequest,
      cn.hua.netty.grpc_example.AnimalResponseList> METHOD_GET_ANIMAL_RESPONSE_LIST_BY_AGES = getGetAnimalResponseListByAgesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.AnimalRequest,
      cn.hua.netty.grpc_example.AnimalResponseList> getGetAnimalResponseListByAgesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.AnimalRequest,
      cn.hua.netty.grpc_example.AnimalResponseList> getGetAnimalResponseListByAgesMethod() {
    return getGetAnimalResponseListByAgesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.AnimalRequest,
      cn.hua.netty.grpc_example.AnimalResponseList> getGetAnimalResponseListByAgesMethodHelper() {
    io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.AnimalRequest, cn.hua.netty.grpc_example.AnimalResponseList> getGetAnimalResponseListByAgesMethod;
    if ((getGetAnimalResponseListByAgesMethod = AnimalServiceGrpc.getGetAnimalResponseListByAgesMethod) == null) {
      synchronized (AnimalServiceGrpc.class) {
        if ((getGetAnimalResponseListByAgesMethod = AnimalServiceGrpc.getGetAnimalResponseListByAgesMethod) == null) {
          AnimalServiceGrpc.getGetAnimalResponseListByAgesMethod = getGetAnimalResponseListByAgesMethod = 
              io.grpc.MethodDescriptor.<cn.hua.netty.grpc_example.AnimalRequest, cn.hua.netty.grpc_example.AnimalResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "cn.hua.netty.grpc_example.AnimalService", "getAnimalResponseListByAges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hua.netty.grpc_example.AnimalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hua.netty.grpc_example.AnimalResponseList.getDefaultInstance()))
                  .setSchemaDescriptor(new AnimalServiceMethodDescriptorSupplier("getAnimalResponseListByAges"))
                  .build();
          }
        }
     }
     return getGetAnimalResponseListByAgesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBiTalkMethod()} instead. 
  public static final io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.StreamRequest,
      cn.hua.netty.grpc_example.StreamResponse> METHOD_BI_TALK = getBiTalkMethodHelper();

  private static volatile io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.StreamRequest,
      cn.hua.netty.grpc_example.StreamResponse> getBiTalkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.StreamRequest,
      cn.hua.netty.grpc_example.StreamResponse> getBiTalkMethod() {
    return getBiTalkMethodHelper();
  }

  private static io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.StreamRequest,
      cn.hua.netty.grpc_example.StreamResponse> getBiTalkMethodHelper() {
    io.grpc.MethodDescriptor<cn.hua.netty.grpc_example.StreamRequest, cn.hua.netty.grpc_example.StreamResponse> getBiTalkMethod;
    if ((getBiTalkMethod = AnimalServiceGrpc.getBiTalkMethod) == null) {
      synchronized (AnimalServiceGrpc.class) {
        if ((getBiTalkMethod = AnimalServiceGrpc.getBiTalkMethod) == null) {
          AnimalServiceGrpc.getBiTalkMethod = getBiTalkMethod = 
              io.grpc.MethodDescriptor.<cn.hua.netty.grpc_example.StreamRequest, cn.hua.netty.grpc_example.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "cn.hua.netty.grpc_example.AnimalService", "biTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hua.netty.grpc_example.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.hua.netty.grpc_example.StreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AnimalServiceMethodDescriptorSupplier("biTalk"))
                  .build();
          }
        }
     }
     return getBiTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AnimalServiceStub newStub(io.grpc.Channel channel) {
    return new AnimalServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnimalServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AnimalServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AnimalServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AnimalServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AnimalServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealNameByUserName(cn.hua.netty.grpc_example.MyRequest request,
        io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUserNameMethodHelper(), responseObserver);
    }

    /**
     */
    public void getAnimalsByAge(cn.hua.netty.grpc_example.AnimalRequest request,
        io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.AnimalResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAnimalsByAgeMethodHelper(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.AnimalRequest> getAnimalResponseListByAges(
        io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.AnimalResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetAnimalResponseListByAgesMethodHelper(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiTalkMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUserNameMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.hua.netty.grpc_example.MyRequest,
                cn.hua.netty.grpc_example.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USER_NAME)))
          .addMethod(
            getGetAnimalsByAgeMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                cn.hua.netty.grpc_example.AnimalRequest,
                cn.hua.netty.grpc_example.AnimalResponse>(
                  this, METHODID_GET_ANIMALS_BY_AGE)))
          .addMethod(
            getGetAnimalResponseListByAgesMethodHelper(),
            asyncClientStreamingCall(
              new MethodHandlers<
                cn.hua.netty.grpc_example.AnimalRequest,
                cn.hua.netty.grpc_example.AnimalResponseList>(
                  this, METHODID_GET_ANIMAL_RESPONSE_LIST_BY_AGES)))
          .addMethod(
            getBiTalkMethodHelper(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                cn.hua.netty.grpc_example.StreamRequest,
                cn.hua.netty.grpc_example.StreamResponse>(
                  this, METHODID_BI_TALK)))
          .build();
    }
  }

  /**
   */
  public static final class AnimalServiceStub extends io.grpc.stub.AbstractStub<AnimalServiceStub> {
    private AnimalServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AnimalServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnimalServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AnimalServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealNameByUserName(cn.hua.netty.grpc_example.MyRequest request,
        io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUserNameMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAnimalsByAge(cn.hua.netty.grpc_example.AnimalRequest request,
        io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.AnimalResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAnimalsByAgeMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.AnimalRequest> getAnimalResponseListByAges(
        io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.AnimalResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetAnimalResponseListByAgesMethodHelper(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiTalkMethodHelper(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AnimalServiceBlockingStub extends io.grpc.stub.AbstractStub<AnimalServiceBlockingStub> {
    private AnimalServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AnimalServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnimalServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AnimalServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.hua.netty.grpc_example.MyResponse getRealNameByUserName(cn.hua.netty.grpc_example.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUserNameMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<cn.hua.netty.grpc_example.AnimalResponse> getAnimalsByAge(
        cn.hua.netty.grpc_example.AnimalRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAnimalsByAgeMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AnimalServiceFutureStub extends io.grpc.stub.AbstractStub<AnimalServiceFutureStub> {
    private AnimalServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AnimalServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnimalServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AnimalServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.hua.netty.grpc_example.MyResponse> getRealNameByUserName(
        cn.hua.netty.grpc_example.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUserNameMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USER_NAME = 0;
  private static final int METHODID_GET_ANIMALS_BY_AGE = 1;
  private static final int METHODID_GET_ANIMAL_RESPONSE_LIST_BY_AGES = 2;
  private static final int METHODID_BI_TALK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AnimalServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AnimalServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USER_NAME:
          serviceImpl.getRealNameByUserName((cn.hua.netty.grpc_example.MyRequest) request,
              (io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.MyResponse>) responseObserver);
          break;
        case METHODID_GET_ANIMALS_BY_AGE:
          serviceImpl.getAnimalsByAge((cn.hua.netty.grpc_example.AnimalRequest) request,
              (io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.AnimalResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ANIMAL_RESPONSE_LIST_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getAnimalResponseListByAges(
              (io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.AnimalResponseList>) responseObserver);
        case METHODID_BI_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTalk(
              (io.grpc.stub.StreamObserver<cn.hua.netty.grpc_example.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AnimalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnimalServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.hua.netty.grpc_example.AnimalProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AnimalService");
    }
  }

  private static final class AnimalServiceFileDescriptorSupplier
      extends AnimalServiceBaseDescriptorSupplier {
    AnimalServiceFileDescriptorSupplier() {}
  }

  private static final class AnimalServiceMethodDescriptorSupplier
      extends AnimalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AnimalServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AnimalServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AnimalServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUserNameMethodHelper())
              .addMethod(getGetAnimalsByAgeMethodHelper())
              .addMethod(getGetAnimalResponseListByAgesMethodHelper())
              .addMethod(getBiTalkMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
