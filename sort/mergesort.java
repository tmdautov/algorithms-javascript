// ES6 flag --harmony_default_parameters needed when run in Node 5.0.0
function mergesort(list, compare = (x, y) => {return x < y} ) {

  // breaking recursive call
  if(list.length <= 1) return list;

  // ES6 flag --harmony_destructuring needed when run in Node 5.0.0
  var {leftHalf, rigthHalf } = splitList(list);

  // Recursive call.
  // Passing compare function to recursive calls to prevent the creation of unnecessary
  // functions on each call.
  return jointLists(mergesort(leftHalf, compare), mergesort(rigthHalf, compare), compare);
}

function splitList(list){
  if (list.length == 0) return {leftHalf : [], rigthHalf: []};
  if (list.length == 1) return {leftHalf : list , rigthHalf : []};
  var index = Math.floor(list.length / 2);
  return {leftHalf : list.slice(0, index), rigthHalf : list.slice(index)};
}

function jointLists(list1, list2, compare){

  // getting the biggest array
  var iterator = list1.length > list2.length ? list1.length : list2.length;

  // defining auxiliar variables
  var [result, index1, index2] = [[], 0, 0];

  // sortering previously ordered arrays
  while(true){
    if(compare(list1[index1], list2[index2])){
      result.push(list1[index1]);
      index1++;
    } else {
      result.push(list2[index2]);
      index2++;
    }
    if(index1 == list1.length || index2 == list2.length) break;
  }

  // some of the array still have elements that are not listed on the result arrays,
  // since this elements have a biggest value (according to the compare function)
  // we can just push this elements at the very end of the result
  if(index1 < list1.length) return result.concat(list1.slice(index1));
  if(index2 < list2.length) return result.concat(list2.slice(index2));
  return result;
}

console.log(mergesort([34, -2, 3 , 5, -6, 1, 35]));
