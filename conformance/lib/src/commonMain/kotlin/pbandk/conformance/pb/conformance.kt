@file:OptIn(pbandk.PublicForGeneratedCode::class)

package pbandk.conformance.pb

@pbandk.Export
public sealed class WireFormat(override val value: Int, override val name: String? = null) : pbandk.Message.Enum {
    override fun equals(other: kotlin.Any?): Boolean = other is pbandk.conformance.pb.WireFormat && other.value == value
    override fun hashCode(): Int = value.hashCode()
    override fun toString(): String = "WireFormat.${name ?: "UNRECOGNIZED"}(value=$value)"

    public object UNSPECIFIED : WireFormat(0, "UNSPECIFIED")
    public object PROTOBUF : WireFormat(1, "PROTOBUF")
    public object JSON : WireFormat(2, "JSON")
    public object JSPB : WireFormat(3, "JSPB")
    public object TEXT_FORMAT : WireFormat(4, "TEXT_FORMAT")
    public class UNRECOGNIZED(value: Int) : WireFormat(value)

    public companion object : pbandk.Message.Enum.Companion<pbandk.conformance.pb.WireFormat> {
        public val values: List<pbandk.conformance.pb.WireFormat> by lazy { listOf(UNSPECIFIED, PROTOBUF, JSON, JSPB, TEXT_FORMAT) }
        override fun fromValue(value: Int): pbandk.conformance.pb.WireFormat = values.firstOrNull { it.value == value } ?: UNRECOGNIZED(value)
        override fun fromName(name: String): pbandk.conformance.pb.WireFormat = values.firstOrNull { it.name == name } ?: throw IllegalArgumentException("No WireFormat with name: $name")
    }
}

@pbandk.Export
public sealed class TestCategory(override val value: Int, override val name: String? = null) : pbandk.Message.Enum {
    override fun equals(other: kotlin.Any?): Boolean = other is pbandk.conformance.pb.TestCategory && other.value == value
    override fun hashCode(): Int = value.hashCode()
    override fun toString(): String = "TestCategory.${name ?: "UNRECOGNIZED"}(value=$value)"

    public object UNSPECIFIED_TEST : TestCategory(0, "UNSPECIFIED_TEST")
    public object BINARY_TEST : TestCategory(1, "BINARY_TEST")
    public object JSON_TEST : TestCategory(2, "JSON_TEST")
    public object JSON_IGNORE_UNKNOWN_PARSING_TEST : TestCategory(3, "JSON_IGNORE_UNKNOWN_PARSING_TEST")
    public object JSPB_TEST : TestCategory(4, "JSPB_TEST")
    public object TEXT_FORMAT_TEST : TestCategory(5, "TEXT_FORMAT_TEST")
    public class UNRECOGNIZED(value: Int) : TestCategory(value)

    public companion object : pbandk.Message.Enum.Companion<pbandk.conformance.pb.TestCategory> {
        public val values: List<pbandk.conformance.pb.TestCategory> by lazy { listOf(UNSPECIFIED_TEST, BINARY_TEST, JSON_TEST, JSON_IGNORE_UNKNOWN_PARSING_TEST, JSPB_TEST, TEXT_FORMAT_TEST) }
        override fun fromValue(value: Int): pbandk.conformance.pb.TestCategory = values.firstOrNull { it.value == value } ?: UNRECOGNIZED(value)
        override fun fromName(name: String): pbandk.conformance.pb.TestCategory = values.firstOrNull { it.name == name } ?: throw IllegalArgumentException("No TestCategory with name: $name")
    }
}

@pbandk.Export
public data class FailureSet(
    val failure: List<String> = emptyList(),
    override val unknownFields: Map<Int, pbandk.UnknownField> = emptyMap()
) : pbandk.Message {
    override operator fun plus(other: pbandk.Message?): pbandk.conformance.pb.FailureSet = protoMergeImpl(other)
    override val descriptor: pbandk.MessageDescriptor<pbandk.conformance.pb.FailureSet> get() = Companion.descriptor
    override val protoSize: Int by lazy { super.protoSize }
    public companion object : pbandk.Message.Companion<pbandk.conformance.pb.FailureSet> {
        public val defaultInstance: pbandk.conformance.pb.FailureSet by lazy { pbandk.conformance.pb.FailureSet() }
        override fun decodeWith(u: pbandk.MessageDecoder): pbandk.conformance.pb.FailureSet = pbandk.conformance.pb.FailureSet.decodeWithImpl(u)

        override val descriptor: pbandk.MessageDescriptor<pbandk.conformance.pb.FailureSet> = pbandk.MessageDescriptor(
            fullName = "conformance.FailureSet",
            messageClass = pbandk.conformance.pb.FailureSet::class,
            messageCompanion = this,
            fields = buildList(1) {
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "failure",
                        number = 1,
                        type = pbandk.FieldDescriptor.Type.Repeated<String>(valueType = pbandk.FieldDescriptor.Type.Primitive.String()),
                        jsonName = "failure",
                        value = pbandk.conformance.pb.FailureSet::failure
                    )
                )
            }
        )
    }
}

@pbandk.Export
public data class ConformanceRequest(
    val requestedOutputFormat: pbandk.conformance.pb.WireFormat = pbandk.conformance.pb.WireFormat.fromValue(0),
    val messageType: String = "",
    val testCategory: pbandk.conformance.pb.TestCategory = pbandk.conformance.pb.TestCategory.fromValue(0),
    val jspbEncodingOptions: pbandk.conformance.pb.JspbEncodingConfig? = null,
    val printUnknownFields: Boolean = false,
    val payload: Payload<*>? = null,
    override val unknownFields: Map<Int, pbandk.UnknownField> = emptyMap()
) : pbandk.Message {
    public sealed class Payload<V>(value: V) : pbandk.Message.OneOf<V>(value) {
        public class ProtobufPayload(protobufPayload: pbandk.ByteArr = pbandk.ByteArr.empty) : Payload<pbandk.ByteArr>(protobufPayload)
        public class JsonPayload(jsonPayload: String = "") : Payload<String>(jsonPayload)
        public class JspbPayload(jspbPayload: String = "") : Payload<String>(jspbPayload)
        public class TextPayload(textPayload: String = "") : Payload<String>(textPayload)
    }

    val protobufPayload: pbandk.ByteArr?
        get() = (payload as? Payload.ProtobufPayload)?.value
    val jsonPayload: String?
        get() = (payload as? Payload.JsonPayload)?.value
    val jspbPayload: String?
        get() = (payload as? Payload.JspbPayload)?.value
    val textPayload: String?
        get() = (payload as? Payload.TextPayload)?.value

    override operator fun plus(other: pbandk.Message?): pbandk.conformance.pb.ConformanceRequest = protoMergeImpl(other)
    override val descriptor: pbandk.MessageDescriptor<pbandk.conformance.pb.ConformanceRequest> get() = Companion.descriptor
    override val protoSize: Int by lazy { super.protoSize }
    public companion object : pbandk.Message.Companion<pbandk.conformance.pb.ConformanceRequest> {
        public val defaultInstance: pbandk.conformance.pb.ConformanceRequest by lazy { pbandk.conformance.pb.ConformanceRequest() }
        override fun decodeWith(u: pbandk.MessageDecoder): pbandk.conformance.pb.ConformanceRequest = pbandk.conformance.pb.ConformanceRequest.decodeWithImpl(u)

        override val descriptor: pbandk.MessageDescriptor<pbandk.conformance.pb.ConformanceRequest> = pbandk.MessageDescriptor(
            fullName = "conformance.ConformanceRequest",
            messageClass = pbandk.conformance.pb.ConformanceRequest::class,
            messageCompanion = this,
            fields = buildList(9) {
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "protobuf_payload",
                        number = 1,
                        type = pbandk.FieldDescriptor.Type.Primitive.Bytes(hasPresence = true),
                        oneofMember = true,
                        jsonName = "protobufPayload",
                        value = pbandk.conformance.pb.ConformanceRequest::protobufPayload
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "json_payload",
                        number = 2,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "jsonPayload",
                        value = pbandk.conformance.pb.ConformanceRequest::jsonPayload
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "requested_output_format",
                        number = 3,
                        type = pbandk.FieldDescriptor.Type.Enum(enumCompanion = pbandk.conformance.pb.WireFormat.Companion),
                        jsonName = "requestedOutputFormat",
                        value = pbandk.conformance.pb.ConformanceRequest::requestedOutputFormat
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "message_type",
                        number = 4,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(),
                        jsonName = "messageType",
                        value = pbandk.conformance.pb.ConformanceRequest::messageType
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "test_category",
                        number = 5,
                        type = pbandk.FieldDescriptor.Type.Enum(enumCompanion = pbandk.conformance.pb.TestCategory.Companion),
                        jsonName = "testCategory",
                        value = pbandk.conformance.pb.ConformanceRequest::testCategory
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "jspb_encoding_options",
                        number = 6,
                        type = pbandk.FieldDescriptor.Type.Message(messageCompanion = pbandk.conformance.pb.JspbEncodingConfig.Companion),
                        jsonName = "jspbEncodingOptions",
                        value = pbandk.conformance.pb.ConformanceRequest::jspbEncodingOptions
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "jspb_payload",
                        number = 7,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "jspbPayload",
                        value = pbandk.conformance.pb.ConformanceRequest::jspbPayload
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "text_payload",
                        number = 8,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "textPayload",
                        value = pbandk.conformance.pb.ConformanceRequest::textPayload
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "print_unknown_fields",
                        number = 9,
                        type = pbandk.FieldDescriptor.Type.Primitive.Bool(),
                        jsonName = "printUnknownFields",
                        value = pbandk.conformance.pb.ConformanceRequest::printUnknownFields
                    )
                )
            }
        )
    }
}

@pbandk.Export
public data class ConformanceResponse(
    val result: Result<*>? = null,
    override val unknownFields: Map<Int, pbandk.UnknownField> = emptyMap()
) : pbandk.Message {
    public sealed class Result<V>(value: V) : pbandk.Message.OneOf<V>(value) {
        public class ParseError(parseError: String = "") : Result<String>(parseError)
        public class SerializeError(serializeError: String = "") : Result<String>(serializeError)
        public class TimeoutError(timeoutError: String = "") : Result<String>(timeoutError)
        public class RuntimeError(runtimeError: String = "") : Result<String>(runtimeError)
        public class ProtobufPayload(protobufPayload: pbandk.ByteArr = pbandk.ByteArr.empty) : Result<pbandk.ByteArr>(protobufPayload)
        public class JsonPayload(jsonPayload: String = "") : Result<String>(jsonPayload)
        public class Skipped(skipped: String = "") : Result<String>(skipped)
        public class JspbPayload(jspbPayload: String = "") : Result<String>(jspbPayload)
        public class TextPayload(textPayload: String = "") : Result<String>(textPayload)
    }

    val parseError: String?
        get() = (result as? Result.ParseError)?.value
    val serializeError: String?
        get() = (result as? Result.SerializeError)?.value
    val timeoutError: String?
        get() = (result as? Result.TimeoutError)?.value
    val runtimeError: String?
        get() = (result as? Result.RuntimeError)?.value
    val protobufPayload: pbandk.ByteArr?
        get() = (result as? Result.ProtobufPayload)?.value
    val jsonPayload: String?
        get() = (result as? Result.JsonPayload)?.value
    val skipped: String?
        get() = (result as? Result.Skipped)?.value
    val jspbPayload: String?
        get() = (result as? Result.JspbPayload)?.value
    val textPayload: String?
        get() = (result as? Result.TextPayload)?.value

    override operator fun plus(other: pbandk.Message?): pbandk.conformance.pb.ConformanceResponse = protoMergeImpl(other)
    override val descriptor: pbandk.MessageDescriptor<pbandk.conformance.pb.ConformanceResponse> get() = Companion.descriptor
    override val protoSize: Int by lazy { super.protoSize }
    public companion object : pbandk.Message.Companion<pbandk.conformance.pb.ConformanceResponse> {
        public val defaultInstance: pbandk.conformance.pb.ConformanceResponse by lazy { pbandk.conformance.pb.ConformanceResponse() }
        override fun decodeWith(u: pbandk.MessageDecoder): pbandk.conformance.pb.ConformanceResponse = pbandk.conformance.pb.ConformanceResponse.decodeWithImpl(u)

        override val descriptor: pbandk.MessageDescriptor<pbandk.conformance.pb.ConformanceResponse> = pbandk.MessageDescriptor(
            fullName = "conformance.ConformanceResponse",
            messageClass = pbandk.conformance.pb.ConformanceResponse::class,
            messageCompanion = this,
            fields = buildList(9) {
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "parse_error",
                        number = 1,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "parseError",
                        value = pbandk.conformance.pb.ConformanceResponse::parseError
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "runtime_error",
                        number = 2,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "runtimeError",
                        value = pbandk.conformance.pb.ConformanceResponse::runtimeError
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "protobuf_payload",
                        number = 3,
                        type = pbandk.FieldDescriptor.Type.Primitive.Bytes(hasPresence = true),
                        oneofMember = true,
                        jsonName = "protobufPayload",
                        value = pbandk.conformance.pb.ConformanceResponse::protobufPayload
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "json_payload",
                        number = 4,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "jsonPayload",
                        value = pbandk.conformance.pb.ConformanceResponse::jsonPayload
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "skipped",
                        number = 5,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "skipped",
                        value = pbandk.conformance.pb.ConformanceResponse::skipped
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "serialize_error",
                        number = 6,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "serializeError",
                        value = pbandk.conformance.pb.ConformanceResponse::serializeError
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "jspb_payload",
                        number = 7,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "jspbPayload",
                        value = pbandk.conformance.pb.ConformanceResponse::jspbPayload
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "text_payload",
                        number = 8,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "textPayload",
                        value = pbandk.conformance.pb.ConformanceResponse::textPayload
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "timeout_error",
                        number = 9,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "timeoutError",
                        value = pbandk.conformance.pb.ConformanceResponse::timeoutError
                    )
                )
            }
        )
    }
}

@pbandk.Export
public data class JspbEncodingConfig(
    val useJspbArrayAnyFormat: Boolean = false,
    override val unknownFields: Map<Int, pbandk.UnknownField> = emptyMap()
) : pbandk.Message {
    override operator fun plus(other: pbandk.Message?): pbandk.conformance.pb.JspbEncodingConfig = protoMergeImpl(other)
    override val descriptor: pbandk.MessageDescriptor<pbandk.conformance.pb.JspbEncodingConfig> get() = Companion.descriptor
    override val protoSize: Int by lazy { super.protoSize }
    public companion object : pbandk.Message.Companion<pbandk.conformance.pb.JspbEncodingConfig> {
        public val defaultInstance: pbandk.conformance.pb.JspbEncodingConfig by lazy { pbandk.conformance.pb.JspbEncodingConfig() }
        override fun decodeWith(u: pbandk.MessageDecoder): pbandk.conformance.pb.JspbEncodingConfig = pbandk.conformance.pb.JspbEncodingConfig.decodeWithImpl(u)

        override val descriptor: pbandk.MessageDescriptor<pbandk.conformance.pb.JspbEncodingConfig> = pbandk.MessageDescriptor(
            fullName = "conformance.JspbEncodingConfig",
            messageClass = pbandk.conformance.pb.JspbEncodingConfig::class,
            messageCompanion = this,
            fields = buildList(1) {
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "use_jspb_array_any_format",
                        number = 1,
                        type = pbandk.FieldDescriptor.Type.Primitive.Bool(),
                        jsonName = "useJspbArrayAnyFormat",
                        value = pbandk.conformance.pb.JspbEncodingConfig::useJspbArrayAnyFormat
                    )
                )
            }
        )
    }
}

@pbandk.Export
@pbandk.JsName("orDefaultForFailureSet")
public fun FailureSet?.orDefault(): pbandk.conformance.pb.FailureSet = this ?: FailureSet.defaultInstance

private fun FailureSet.protoMergeImpl(plus: pbandk.Message?): FailureSet = (plus as? FailureSet)?.let {
    it.copy(
        failure = failure + plus.failure,
        unknownFields = unknownFields + plus.unknownFields
    )
} ?: this

@Suppress("UNCHECKED_CAST")
private fun FailureSet.Companion.decodeWithImpl(u: pbandk.MessageDecoder): FailureSet {
    var failure: pbandk.ListWithSize.Builder<String>? = null

    val unknownFields = u.readMessage(this) { _fieldNumber, _fieldValue ->
        when (_fieldNumber) {
            1 -> failure = (failure ?: pbandk.ListWithSize.Builder()).apply { this += _fieldValue as kotlin.sequences.Sequence<String> }
        }
    }

    return FailureSet(pbandk.ListWithSize.Builder.fixed(failure), unknownFields)
}

@pbandk.Export
@pbandk.JsName("orDefaultForConformanceRequest")
public fun ConformanceRequest?.orDefault(): pbandk.conformance.pb.ConformanceRequest = this ?: ConformanceRequest.defaultInstance

private fun ConformanceRequest.protoMergeImpl(plus: pbandk.Message?): ConformanceRequest = (plus as? ConformanceRequest)?.let {
    it.copy(
        jspbEncodingOptions = jspbEncodingOptions?.plus(plus.jspbEncodingOptions) ?: plus.jspbEncodingOptions,
        payload = plus.payload ?: payload,
        unknownFields = unknownFields + plus.unknownFields
    )
} ?: this

@Suppress("UNCHECKED_CAST")
private fun ConformanceRequest.Companion.decodeWithImpl(u: pbandk.MessageDecoder): ConformanceRequest {
    var requestedOutputFormat: pbandk.conformance.pb.WireFormat = pbandk.conformance.pb.WireFormat.fromValue(0)
    var messageType = ""
    var testCategory: pbandk.conformance.pb.TestCategory = pbandk.conformance.pb.TestCategory.fromValue(0)
    var jspbEncodingOptions: pbandk.conformance.pb.JspbEncodingConfig? = null
    var printUnknownFields = false
    var payload: ConformanceRequest.Payload<*>? = null

    val unknownFields = u.readMessage(this) { _fieldNumber, _fieldValue ->
        when (_fieldNumber) {
            1 -> payload = ConformanceRequest.Payload.ProtobufPayload(_fieldValue as pbandk.ByteArr)
            2 -> payload = ConformanceRequest.Payload.JsonPayload(_fieldValue as String)
            3 -> requestedOutputFormat = _fieldValue as pbandk.conformance.pb.WireFormat
            4 -> messageType = _fieldValue as String
            5 -> testCategory = _fieldValue as pbandk.conformance.pb.TestCategory
            6 -> jspbEncodingOptions = _fieldValue as pbandk.conformance.pb.JspbEncodingConfig
            7 -> payload = ConformanceRequest.Payload.JspbPayload(_fieldValue as String)
            8 -> payload = ConformanceRequest.Payload.TextPayload(_fieldValue as String)
            9 -> printUnknownFields = _fieldValue as Boolean
        }
    }

    return ConformanceRequest(requestedOutputFormat, messageType, testCategory, jspbEncodingOptions,
        printUnknownFields, payload, unknownFields)
}

@pbandk.Export
@pbandk.JsName("orDefaultForConformanceResponse")
public fun ConformanceResponse?.orDefault(): pbandk.conformance.pb.ConformanceResponse = this ?: ConformanceResponse.defaultInstance

private fun ConformanceResponse.protoMergeImpl(plus: pbandk.Message?): ConformanceResponse = (plus as? ConformanceResponse)?.let {
    it.copy(
        result = plus.result ?: result,
        unknownFields = unknownFields + plus.unknownFields
    )
} ?: this

@Suppress("UNCHECKED_CAST")
private fun ConformanceResponse.Companion.decodeWithImpl(u: pbandk.MessageDecoder): ConformanceResponse {
    var result: ConformanceResponse.Result<*>? = null

    val unknownFields = u.readMessage(this) { _fieldNumber, _fieldValue ->
        when (_fieldNumber) {
            1 -> result = ConformanceResponse.Result.ParseError(_fieldValue as String)
            2 -> result = ConformanceResponse.Result.RuntimeError(_fieldValue as String)
            3 -> result = ConformanceResponse.Result.ProtobufPayload(_fieldValue as pbandk.ByteArr)
            4 -> result = ConformanceResponse.Result.JsonPayload(_fieldValue as String)
            5 -> result = ConformanceResponse.Result.Skipped(_fieldValue as String)
            6 -> result = ConformanceResponse.Result.SerializeError(_fieldValue as String)
            7 -> result = ConformanceResponse.Result.JspbPayload(_fieldValue as String)
            8 -> result = ConformanceResponse.Result.TextPayload(_fieldValue as String)
            9 -> result = ConformanceResponse.Result.TimeoutError(_fieldValue as String)
        }
    }

    return ConformanceResponse(result, unknownFields)
}

@pbandk.Export
@pbandk.JsName("orDefaultForJspbEncodingConfig")
public fun JspbEncodingConfig?.orDefault(): pbandk.conformance.pb.JspbEncodingConfig = this ?: JspbEncodingConfig.defaultInstance

private fun JspbEncodingConfig.protoMergeImpl(plus: pbandk.Message?): JspbEncodingConfig = (plus as? JspbEncodingConfig)?.let {
    it.copy(
        unknownFields = unknownFields + plus.unknownFields
    )
} ?: this

@Suppress("UNCHECKED_CAST")
private fun JspbEncodingConfig.Companion.decodeWithImpl(u: pbandk.MessageDecoder): JspbEncodingConfig {
    var useJspbArrayAnyFormat = false

    val unknownFields = u.readMessage(this) { _fieldNumber, _fieldValue ->
        when (_fieldNumber) {
            1 -> useJspbArrayAnyFormat = _fieldValue as Boolean
        }
    }

    return JspbEncodingConfig(useJspbArrayAnyFormat, unknownFields)
}
