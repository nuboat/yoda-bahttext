package in.norbor.yoda

import org.scalatest.FunSuite

class BahtTextSpec extends FunSuite {

  val d220_00 = "220.00"
  val t220_00 = "สองร้อยยี่สิบบาทถ้วน"

  test(s"Convert $d220_00 to $t220_00") {
    val result = BahtText.toText(d220_00)

    assert(result === t220_00)
  }

  val d1M_00 = "1000000"
  val t1M_00 = "หนึ่งล้านบาทถ้วน"

  test(s"Convert $d1M_00 to $t1M_00") {
    val result = BahtText.toText(d1M_00)

    assert(result === t1M_00)
  }

}
