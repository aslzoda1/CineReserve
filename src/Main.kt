import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val seats = Array(5) { IntArray(5) { 0 } }

    println("🎬 CineReserve: Aqlli Band Qilish Tizimi")

    while (true) {
        println("\n--- 📝 ASOSIY MENYU ---")
        println("1. Zaldagi bo'sh joylarni ko'rish")
        println("2. Joy band qilish")
        println("3. Band qilingan joyni bekor qilish")
        println("0. Chiqish")
        print("Tanlov: ")

        when (scanner.nextInt()) {
            1 -> {
                println("\n🎭 SAHNA (EKRAN SHU YERDA)")
                println("      1  2  3  4  5")
                for (i in seats.indices) {
                    print("${i + 1}-qator: ")
                    for (j in seats[i].indices) {
                        val status = if (seats[i][j] == 0) "🟢" else "🔴"
                        print("$status ")
                    }
                    println()
                }
                println("\n(🟢 - Bo'sh, 🔴 - Band)")
            }
            2 -> {
                print("Qatorni tanlang (1-5): ")
                val row = scanner.nextInt() - 1
                print("O'rindiqni tanlang (1-5): ")
                val col = scanner.nextInt() - 1

                if (row in 0..4 && col in 0..4) {
                    if (seats[row][col] == 0) {
                        seats[row][col] = 1
                        println("✅ Muvaffaqiyatli band qilindi!")
                    } else {
                        println("❌ Kechirasiz, bu joy allaqachon band!")
                    }
                } else {
                    println("⚠️ Noto'g'ri qator yoki o'rindiq!")
                }
            }
            3 -> {
                print("Bekor qilmoqchi bo'lgan qator: ")
                val row = scanner.nextInt() - 1
                print("O'rindiq: ")
                val col = scanner.nextInt() - 1

                if (row in 0..4 && col in 0..4) {
                    if (seats[row][col] == 1) {
                        seats[row][col] = 0
                        println("🔓 Joy bo'shatildi!")
                    } else {
                        println("❓ Bu joy allaqachon bo'sh.")
                    }
                }
            }
            0 -> {
                println("Xizmatdan foydalanganingiz uchun rahmat! 🍿")
                return
            }
            else -> println("⚠️ Noto'g'ri buyruq!")
        }
    }
}