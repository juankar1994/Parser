section .text
	global _start
_start:  
	mov eax, 12
	mov ebx, 1
	sub eax,ebx
	mov [var_1],eax
label_1: 
	mov ax, 2
	ret
label_2: 
	mov eax, 12
	mov ebx, 10
	sub eax,ebx
	mov [var_2],eax
	mov eax, var_1
	neg eax
	mov [var_3],eax
	mov eax, var_3
	mov ebx, var_1
	add eax,ebx
	mov [var_4],eax
label_3: 
	mov eax,0 
	cmp eax, 0 
	JNZ label_4
	call hola
	JMP label_3 
label_4: 
	mov eax,var_3 
	cmp eax, 0 
	JNZ label_5
	mov ax, 1
	ret
	JMP label_6 
label_5: 
	mov ax, 2
	ret
label_6: 

	mov eax, 1
	mov ebx, 0
	int 80h

section     .data

	var_1:    resb 1
	var_2:    resb 1
	var_3:    resb 1
	var_4:    resb 1
	var_5:    resb 1
