package utils

private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

fun generateUniqueId(length: Int = 16): String {
    return (1..length)
        .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString("")
}
