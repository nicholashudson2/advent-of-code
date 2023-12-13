#!/bin/bash
## Create list of file names
declare -a arr=("day_two_input.txt" "day_three_input.txt" "day_four_input.txt" "day_five_input.txt" "day_six_input.txt" "day_seven_input.txt" "day_eight_input.txt" "day_nine_input.txt" "day_ten_input.txt" "day_eleven_input.txt" "day_twelve_input.txt" "day_thirteen_input.txt" "day_fourteen_input.txt" "day_fifteen_input.txt" "day_sixteen_input.txt" "day_seventeen_input.txt" "day_eighteen_input.txt" "day_nineteen_input.txt" "day_twenty_input.txt" "day_twenty_one_input.txt" "day_twenty_two_input.txt" "day_twenty_three_input.txt" "day_twenty_four_input.txt" "day_twenty_five_input.txt")

## Iterate over file names create new file for each
for i in "${arr[@]}"
do
   touch "$i"
   # or do whatever with individual element of the array
done