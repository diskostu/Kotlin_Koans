// Return a customer who has placed the maximum amount of orders
fun Shop.getCustomerWithMaxOrders(): Customer? =
    customers.maxByOrNull { it.orders.size }

// Return the most expensive product that has been ordered by the given customer
fun getMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders.flatMap { it.products }.maxByOrNull { it.price }


fun main() {
    // demo code to find the solutions
    val shop = createSampleShop()

    println("shop.getCustomerWithMaxOrders() = ${shop.getCustomerWithMaxOrders()}")

    val customer = shop.customers[0]
    val flatMap = customer.orders.flatMap { it.products }
    val mostExpensiveProduct = flatMap.maxByOrNull { it.price }
    println("maxByOrNull = $mostExpensiveProduct")
}

fun createSampleShop(): Shop {
    // create some sample entities
    val product1 = Product("product 1", 1.0)
    val product2 = Product("product 2", 2.0)
    val product3 = Product("product 3", 3.0)
    val product4 = Product("product 4", 4.0)
    val product5 = Product("product 4", 5.0)

    val order1 = Order(listOf(product1), false)
    val order2 = Order(listOf(product2, product3), false)
    val order3 = Order(listOf(product1, product3, product4), false)

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
