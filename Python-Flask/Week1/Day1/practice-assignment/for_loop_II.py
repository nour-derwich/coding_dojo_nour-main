
def coutdown(num):
 arr=[]
 for i in range(num ,-1,-1):
    arr.append(i)
    print(arr)
 return arr


food=coutdown(5)
print(food)
#############################
def print_and_return(book):
   print(book[0])
   return[book[1]]

Note_Book=print_and_return([3,15])
print (Note_Book)
##########################################
def first_plus_length(x):
   sum=x[0]+len(x)
   return sum
test=first_plus_length([1,5,6,8,9,66,552,852])
print(test)
######################################
new_list=[]
def values_greater_than_second(arr):
   v=0
   if len(arr)>1 :
      for i in range(0,len(arr)):
       if arr[i]>arr[1]:
        new_list.append(arr[i])
       else:
         v+=1
      print(v)
      return new_list
   else:
      return False

lol = values_greater_than_second([0,3,0,10,1,4]) 
print(lol)

erre = values_greater_than_second([100])
print(erre)

####################################
list0=[]
def length_and_value(size,value):
   for j in range(0, size):
      list0.append(value)
   return list0
result=length_and_value(3,5)
print(result)

###############
students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]
iterateDictionary(students) 
# should output: (it's okay if each key-value pair ends up on 2 separate lines;
# bonus to get them to appear exactly as below!)
first_name - Michael, last_name - Jordan
first_name - John, last_name - Rosales
first_name - Mark, last_name - Guillen
first_name - KB, last_name - Tonel
def iterateDictionary2(key_name, some_list):
    





        
