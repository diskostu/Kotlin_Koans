// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap { it.products }

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =
    customers.flatMap { it.orders }.flatMap { it.products }.toSet()


fun main() {
    // demo code to find the solutions
    val shop = createSampleShop()
    val customer1 = shop.customers[0]

    val orderedProducts = customer1.getOrderedProducts()
    println("orderedProducts = $orderedProducts")


    val flatMap = shop.customers.flatMap { it.orders }
    println("flatMap = $flatMap")

    val flatMap1 = flatMap.flatMap { it.products }.sortedBy { it.name }.toSet()
    println("flatMap1 = $flatMap1")

    // thast's it
    val toSet = shop.customers.flatMap { it.orders }.flatMap { it.products }.toSet()
    println("toSet = $toSet")
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
