addi $s3 $zero 1
addi $s1 $zero 5
addi $s2 $zero 2
beq $s1, $t1, 4
mul $s3, $s3, $s2
addi $t1 $t1 1
j 3