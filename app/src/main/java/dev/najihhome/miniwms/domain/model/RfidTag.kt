package dev.najihhome.miniwms.domain.model

data class RfidTag(
    val id: String,
    val isRegistered: Boolean = false,
    var productId: Int? = null,
    var productName: String? = null,
    var attributeValues: Map<String, String> = mapOf()
)

object DummyRfidTags {
    val tags = listOf(
        RfidTag("E28068940000502FBAB2DD7B"),
        RfidTag("E280689400005025A9F36CDC"),
        RfidTag("E2806894000050248554F55C"),
        RfidTag("E200470F92E0602275CC010C"),
        RfidTag("E28068900000500D7B94DCBD"),
        RfidTag("E202345370011F64E82FDAF9"),
        RfidTag("E28068940000502FBAB2DC86"),
        RfidTag("E202345370021E4F542B09FD"),
        RfidTag("E200470F94A0602275E8010D"),
        RfidTag("E20000193117003912209BCE")
    )
}
