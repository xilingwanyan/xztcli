package org.xzt

import kotlin.random.*

fun main() {
    while (true) {
        println("选择题选择助手".colorBold("33"))
        println("""
            >v1 (old)
            >v2 (fast)
            >v3 (lite)
            """.trimMargin(">").colorBold("32")
        )
        print(": ".colorBold("34"))
        val xz = readlnOrNull()
        when (xz) {
            null -> {
                println()
                break
            }
            "v1", "1" -> runVersion1()
            "v2", "2" -> runVersion2()
            "v3", "3" -> runVersion3()
            else -> println("数值无效".colorBold("31"))
        }
    }
}

fun String.color(colorCode: String) =
    "\u001B[0;${colorCode}m${this}\u001B[0m"
fun String.colorBold(colorCode: String) =
    "\u001B[1;${colorCode}m${this}\u001B[0m" // 实现颜色String

// WARNING: This function is deprecated
@Deprecated("old")
fun runVersion1() {
    while (true) {
        println("选择题选择助手v1".colorBold("95"))
        print("输入选择数目[max==6]: ".colorBold("34"))
        val maxInputnput = readlnOrNull()
        if (maxInputnput == null) {
            println()
            break
        }
        val max = maxInputnput.toIntOrNull()
        if (max == null || max !in 1..6) {
            println("数值无效".colorBold("31"))
            continue
        }
        print("输入数量: ".colorBold("34"))
        val sizeInput = readlnOrNull()
        if (sizeInput == null) {
            println()
            break
        }
        val size = sizeInput.toIntOrNull()
        if (size == null || size <= 0) {
            println("数值无效".colorBold("31"))
            continue
        }
        println("准备生成...".colorBold("33"))
        val out: MutableList<String> = mutableListOf()
        for (i in 1..size) {
            val s = Random.nextInt(1, max + 1)
            val ss = when (s) {
                1 -> "A"
                2 -> "B"
                3 -> "C"
                4 -> "D"
                5 -> "E"
                6 -> "F"
                else -> "null"
            }
            out.add(ss)
        } // 随机数转换为随机字母并追加到list中
        val outLength = out.size.toString().length // 列表长度的字符串字数
        val endLength = if (out.size / 5 * 5 == out.size) {
            out.size - 5
        } else {
            out.size / 5 * 5
        }.toString().length // 最后一行打印首个数字的字符串字数
        val printLength = outLength + endLength // 最后一行打印的数字的字符串字数
        val fen = "-".repeat(printLength + 14).colorBold("32") // 动态分界符
        println(fen)
        val end = if (out.size % 5 != 0) {
            out.size / 5 * 5
        } else {
            -1
        }
        // 为首行做特殊处理
        if (out.size < 5) {
            print("1-${out.size}  ".colorBold("33"))
        } else {
            print("1-5  ".colorBold("33"))
        }
        print(" ".repeat(printLength - 2))
        for (e in 1..out.size) {
            print("${out[e - 1]} ") // 打印字母
            if (e == end) {
                print("\n${e + 1}-${out.size}  ".colorBold("33"))
            } // 特殊范围指示
            else if (e % 5 == 0 && e != out.size) {
                val eA5 = e + 5
                // -val nowLength = e.toString().length + eA4.toString().length
                print("\n${e + 1}-$eA5  ".colorBold("33"))
                print(" ".repeat(printLength - e.toString().length - eA5.toString().length)) // 添加空格保存排版对齐
            } // 在指定位置添加范围指示
        }
        println("\n$fen")
    }
}

fun runVersion2() {
    while (true) {
        println("选择题选择助手v2".colorBold("95"))
        print("输入选择数目[max==6]: ".colorBold("34"))
        val maxInput = readlnOrNull()
        if (maxInput == null) {
            println()
            break
        }
        val max = maxInput.toIntOrNull()
        if (max == null || max !in 1..6) {
            println("数值无效".colorBold("31"))
            continue
        }
        print("输入数量: ".colorBold("34"))
        val sizeInput = readlnOrNull()
        if (sizeInput == null) {
            println()
            break
        }
        val size = sizeInput.toIntOrNull()
        if (size == null || size <= 0) {
            println("数值无效".colorBold("31"))
            continue
        }
        println("准备生成...".colorBold("33"))
        val out = CharArray(size)
        val maxPlus1 = max + 1
        for (i in 1..size) {
            val s = Random.nextInt(1, maxPlus1)
            val ss = when (s) {
                1 -> 'A'
                2 -> 'B'
                3 -> 'C'
                4 -> 'D'
                5 -> 'E'
                6 -> 'F'
                else -> 'n'
            }
            out[i - 1] = ss
        } // 随机数转换为随机字母并设置到CharArray中
        val outLength = size.toString().length // 列表长度的字符串字数
        val endLength = if (size % 5 == 0) {
            size - 5
        } else {
            size / 5 * 5
        }.toString().length // 最后一行打印首个数字的字符串字数
        val printLength = outLength + endLength // 最后一行打印的数字的字符串字数
        val fen = "-".repeat(printLength + 14).colorBold("32") // 动态分界符
        println(fen)
        val end = if (size % 5 != 0) {
            size / 5 * 5
        } else {
            -1
        }
        // 为首行做特殊处理
        if (size < 5) {
            print("1-${size}  ".colorBold("33"))
        } else {
            print("1-5  ".colorBold("33"))
        }
        print(" ".repeat(printLength - 2))
        for (i in 1..size) {
            print("${out[i - 1]} ") // 打印字母
            if (i == end) {
                print("\n${i + 1}-${size}  ".colorBold("33"))
            } // 特殊范围指示
            else if (i % 5 == 0 && i != size) {
                val iPlus5 = i + 5
                // -val nowLength = e.toString().length + eA4.toString().length
                print("\n${i + 1}-$iPlus5  ".colorBold("33"))
                print(" ".repeat(printLength - i.toString().length - iPlus5.toString().length)) // 添加空格保存排版对齐
            } // 在指定位置添加范围指示
        }
        println("\n$fen")
    }
}

fun runVersion3() {
    while (true) {
        println("选择题选择助手v3".colorBold("95"))
        print("输入选择数目[max==6]: ".colorBold("34"))
        val maxInput = readlnOrNull()
        if (maxInput == null) {
            println()
            break
        }
        val max = maxInput.toIntOrNull()
        if (max == null || max !in 1..6) {
            println("数值无效".colorBold("31"))
            continue
        }
        print("输入数量: ".colorBold("34"))
        val sizeInput = readlnOrNull()
        if (sizeInput == null) {
            println()
            break
        }
        val size = sizeInput.toIntOrNull()
        if (size == null || size <= 0) {
            println("数值无效".colorBold("31"))
            continue
        }
        println("准备生成...".colorBold("33"))
        val outLength = size.toString().length // 列表长度的字符串字数
        val endLength = if (size % 5 == 0) {
            size - 5
        } else {
            size / 5 * 5
        }.toString().length // 最后一行打印首个数字的字符串字数
        val printLength = outLength + endLength // 最后一行打印的数字的字符串字数
        val fen = "-".repeat(printLength + 14).colorBold("32") // 动态分界符
        println(fen)
        val end = if (size % 5 != 0) {
            size / 5 * 5
        } else {
            -1
        }
        // 为首行做特殊处理
        val maxPlus1 = max + 1
        if (size < 5) {
            print("1-${size}  ".colorBold("33"))
        } else {
            print("1-5  ".colorBold("33"))
        }
        print(" ".repeat(printLength - 2))
        for (i in 1..size) {
            print(
                when (Random.nextInt(1, maxPlus1)) {
                    1 -> 'A'
                    2 -> 'B'
                    3 -> 'C'
                    4 -> 'D'
                    5 -> 'E'
                    6 -> 'F'
                    else -> 'n'
                }
            ) // 打印字母
            print(" ") // 添加间隔
            if (i == end) {
                print("\n${i + 1}-${size}  ".colorBold("33"))
            } // 特殊范围指示
            else if (i % 5 == 0 && i != size) {
                val iPlus5 = i + 5
                // -val nowLength = e.toString().length + eA4.toString().length
                print("\n${i + 1}-$iPlus5  ".colorBold("33"))
                print(" ".repeat(printLength - i.toString().length - iPlus5.toString().length)) // 添加空格保存排版对齐
            } // 在指定位置添加范围指示
        }
        println("\n$fen")
    }
}
