// Problem: Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.


/*
Example
Input :
[
 [0,1,1,0],
 [0,1,1,0],
 [0,1,1,0],
 [0,0,0,0]
]
Output : 6

*/

// Solution: Let's 


function getMaxRect(matrix){
    var bestUpperLeft = {x: -1, y: -1};
    var bestLowerRight = {x: -1, y: -1};
 
    var cache = new Array(rows+1), stack = []; // JS arrays have push and pop. Awesome!
    for(var i = 0; i < cache.length; i++)
        cache[i] = 0;
 
    for(var x = cols-1; x >= 0; x--){
        updateCache(matrix, x, cache);
        var width = 0;
        for(var y = 0; y < rows+1; y++){
            if(cache[y] > width){
                stack.push({y: y, width: width});
                width = cache[y];
            }
            if(cache[y] < width){
                while(true){
                    var pop = stack.pop();
                    var y0 = pop.y, w0 = pop.width;
                    if(((width * (y - y0)) > area(bestUpperLeft, bestLowerRight)) && (y-y0 >= minQuadY) && (width >= minQuadX)){
                        bestUpperLeft = {x: x, y: y0};
                        bestLowerRight = {x: x+width-1, y: y-1};
                    }
                    width = w0;
                    if(cache[y] >= width)
                        break;
                }
                width = cache[y];
                if(width != 0)
                    stack.push({y: y0, width: w0});
            }
        }
    }
    return { x: bestUpperLeft.x, y: bestUpperLeft.y, lenX: bestLowerRight.x-bestUpperLeft.x+1, lenY: bestLowerRight.y-bestUpperLeft.y+1, area: area(bestUpperLeft, bestLowerRight)};
}
