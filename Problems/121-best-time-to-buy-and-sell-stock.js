/**
 * @param {number[]} prices
 * @return {number}
 */
const maxProfit = (prices) => {
  let minimumPrice = prices[0];
  let maximumProfit = 0;

  prices.forEach((price) => {
    maximumProfit = Math.max(maximumProfit, price - minimumPrice);
    minimumPrice = Math.min(minimumPrice, price);
  });

  return maximumProfit;
};
