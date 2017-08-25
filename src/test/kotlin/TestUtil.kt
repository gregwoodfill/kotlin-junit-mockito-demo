import org.skyscreamer.jsonassert.JSONAssert

infix fun String.shouldEqualJson(jsonString: String) {
    JSONAssert.assertEquals(jsonString, this, false)
}