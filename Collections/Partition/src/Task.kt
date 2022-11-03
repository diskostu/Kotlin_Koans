// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> {
    return customers.filter { customer ->
        // lambda expression can contain multiple lines, as long as the last line (!) contains a
        // criteria
        val (delivered, undelivered) = customer.orders.partition { it.isDelivered }
        undelivered.size > delivered.size
    }.toSet()
}
