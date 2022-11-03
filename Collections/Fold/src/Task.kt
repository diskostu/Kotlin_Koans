// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val allProducts = customers.flatMap { it.orders }.flatMap { it.products }.toSet()

    return customers.fold(allProducts) { orderedByAll, customer ->
        orderedByAll.intersect(customer.getOrderedProducts().toSet())
    }
}

// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap(Order::products)
