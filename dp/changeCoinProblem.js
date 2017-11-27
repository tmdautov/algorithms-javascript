// Problem: https://www.hackerrank.com/challenges/coin-change/problem
// Time complexity: 
// Solution: button up dynamic programming

function makeChange(coins, n) {
  var table = [];
  var m = coins.length
  table[0] = [];
  for (var i = 0; i < m; i++) {
    table[0].push(1);
  }

  for (var i = 1; i < n+1; i++) {
    table[i] = [];
    for (var j = 0; j < m; j++) {
      var coin = coins[j];

      // Count of solutions including coin
      var x = (i-coin >= 0) ? table[i-coin][j]: 0;

      // Count of solutions exluding coin
      var y = (j >= 1)? table[i][j-1]: 0;

      // total count
      table[i][j] = x + y;
    }
  }
  return table[n][m-1];
}
