// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders
        .filter { it.isDelivered }
        .flatMap { it.products }
        .maxByOrNull { it.price }

}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers
        .flatMap { it.orders }
        .flatMap { it.products }
        .count { it == product }
}

fun main() {
    // demo code to find the solutions
    val shop = createSampleShop()

    // task 1
    val mostExpensiveDeliveredProduct = findMostExpensiveProductBy(shop.customers[0])
    println("mostExpensiveDeliveredProduct = $mostExpensiveDeliveredProduct")

    // task 2
    val product3 = shop.customers
        .flatMap { it.orders }
        .flatMap { it.products }
        .first { it.name == "product 3" }

    val allProduct3Count = shop.getNumberOfTimesProductWasOrdered(product3)
    println("allProduct3Count = $allProduct3Count")
}

fun createSampleShop(): Shop {
    // create some sample entities
    val product1 = Product("product 1", 1.0)
    val product2 = Product("product 2", 2.0)
    val product3 = Product("product 3", 3.0)
    val product4 = Product("product 4", 4.0)
    val product5 = Product("product 5", 5.0)

    val order1 = Order(listOf(product1, product3), false)
    val order2 = Order(listOf(product2, product3), true)
    val order3 = Order(listOf(product1, product3, product4), true)

    val customer1 = Customer(
        name = "custumer1",
        city = City("Berlin"),
        orders = listOf(order1, order3)
    )
    val customer2 = Customer(
        name = "custumer2",
        city = City("Hamburg"),
        orders = listOf(order2)
    )

    return Shop("myShop", listOf(customer1, customer2))
}
