// Build a map that stores the customers living in a given city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> =
        customers.groupBy { it.city }


fun main() {
        val shop = createSampleShop()

        val groupCustomersByCity = shop.groupCustomersByCity()
        println("groupCustomersByCity = $groupCustomersByCity")
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
