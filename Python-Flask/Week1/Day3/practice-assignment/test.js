
// obj1={}
// function printRepeating(arr , size)
// {
   
//     for (i = 0; i < size-1; i++)
//     {
//         for (j = i + 1; j < size; j++)
//         {
//             if (arr[i] == arr[j])
//           obj1.push(arr[i])
//         }
//         if(obj1.get(key)==2){
//             print(key + " ");
//         }
//         print(obj1)
//     }
// }

// var arr = [4, 2, 4, 5, 2, 3, 1];
// var arr_size = arr.length;
// printRepeating(arr, arr_size);

// 



const findDuplicates = (arr) => {
 var sorted_arr = arr.slice().sort(); 
 var results = [];
  for (let i = 0; i < sorted_arr.length - 1; i++) {
    if (sorted_arr[i + 1] == sorted_arr[i]) {
      results.push(sorted_arr[i]);
    }
  }
  return results;
}

let duplicatedArray = [9, 9, 111, 2, 3, 4, 4, 5, 7];
console.log(`The duplicates in ${duplicatedArray} are ${findDuplicates(duplicatedArray)}`);

