var limit = 100;

// impure function due to use external variable limit.
function calculatebonus(numSales) 
{
   return(numSales > limit) ? 0.10 * numSales : 0
}

print(calculatebonus(174))

// pure bonus calculation
function calculatebonus2(numSales)
{
   return (numSales > 100) ? 0.10 * numSales : 0
}

print(calculatebonus2(174))