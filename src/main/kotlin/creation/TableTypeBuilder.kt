package creation

import java.lang.StringBuilder

/*
This is the desired Result. A table defined by a dsl using Type-safe Builders and Receiver Types.
The most

fun result() =
    table {
        columns {
            headers {
                this.forEach {
                    header {
                        title { +"Column Title Header ${it.headerTitle}" }
                    }
                }
            }
        }
        rows {
            this.forEach {
                row {
                    cells.forEach {
                        cell {
                            Content { +"Cell Content Text" }
                        }
                    }
                }
            }
        }
    }
*/

//fun Table( init: Table.()->Unit):Table {
//    val table = Table()
//    table.init()
//    return table
//}

interface Element {
    fun render(builder: StringBuilder, indent: String)
}

class TextElement(val text: String) : Element {
    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")
    }
}

data class Column(
    val headerTitle: String
)

data class Table(
    val columns: List<Column> = emptyList()
)

fun table( init: Table.()->Unit):Table = with(Table()) {
    init()
    this
}

fun main() {
    table {
        println("table called $this")
    }
}