addi $s2 $zero 2
addi $s3 $zero 1
addi $t1 $zero 1
beq $t0, $t1, 4
addi $t0, $t0, 1
mul $t1, $t0, $t0
j 0  
addi $s1 $zero 10