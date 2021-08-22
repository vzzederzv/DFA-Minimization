# Chương trình tối tiểu hóa ôtômat hữu hạn đơn định (DFA Minimization)
 
## Hướng dẫn sử dụng
- Lệnh khởi tạo một ôtômat đơn định hữu hạn: `Automata automata = new Automata();`
- Lệnh tạo hàm chuyển cho ôtômat đã tạo: `automata.addTransition(source_state, destination_state, word)`
- Lệnh thiết lập trạng thái bắt đầu: `automata.setStart(“starting_state”)`
- Lệnh thiết lập trạng thái kết thúc: `automata.setFinish(ArrayList<Character> finish)`
- Lệnh in ôtômat: `automata.printAutomata(“fileName.txt”)`

## Cách biểu diễn các loại dữ liệu cần xử lý
Một ôtômat được biểu diễn dưới dạng một đối tượng gồm 5 thuộc tính:
- State (Trạng thái): Mảng động các ký tự.
- Word (Từ ngữ): Mảng động các ký tự.
- Finish (Trạng thái kết thúc): Mảng động các ký tự.
- Map (Hàm chuyển trạng thái): Bảng băm (Hashmap).
- Table (Bảng các hàm chuyển trạng thái): Biểu đồ (Graph).

## Mô tả chương trình
### Input
- Dữ liệu đầu vào là một file có tên input.txt.
- Nội dung file là một văn bản có nhiều dòng, mỗi dòng là dữ liệu của một hàm chuyển trạng thái hoặc dữ liệu thiết lập trạng thái bắt đầu/kết thúc.
- Cấu trúc của dữ liệu hàm chuyển trạng thái là “X Y Z” với:
    + X là trạng thái đầu.
    + Y là trạng thái đích.
    + Z là từ ngữ của hàm chuyển trạng thái.
- Cấu trúc của dữ liệu thiết lập trạng thái bắt đầu là: `start X` với X là trạng thái bắt đầu.
- Cấu trúc của dữ liệu thiết lập trạng thái kết thúc là: `start X` với X là trạng thái kết thúc.
### Minimization
Quá trình tối tiểu hóa được thực hiện theo 2 bước:
- Bước 1: Loại bỏ các trạng thái bị tách biệt và không thể chuyển đổi từ một trạng thái khác.
- Bước 2: Hợp nhất các trạng thái không phân biệt sử dụng thuật toán Hopcroft.
Thuật toán Hopcroft: Sử dụng kỹ thuật Tinh chỉnh phân hoạch (Partition Refinement), các trạng thái của ôtômat sẽ được phân hoạch thành các nhóm nhỏ dựa trên các trạng thái nguồn, trạng thái đích và từ ngữ gắn liền với hàm chuyển của nó. Các nhóm này được coi là nhóm các trạng thái trong cùng một lớp tương đương với nhau theo định lý Myhill–Nerode. Mỗi một cặp trạng thái sẽ được xếp chung một nhóm phân hoạch nếu chúng đều chuyển tới cùng một trạng thái khi có chung ngôn ngữ đầu vào. Mục đích của thuật toán Hopcroft là liên tục phân hoạch các lớp trạng thái tương đương cho tới khi không tồn tại phân hoạch nào nhỏ hơn. Sau đó, ta thống nhất một trạng thái đại diện cho mỗi một lớp tương đương và các trạng thái còn lại sau cùng chính là ôtômat đã được tối tiểu hóa.

### Output
- Dữ liệu đầu ra là một file có tên output.txt.
- Nội dung file là ôtômat đã tối tiểu hóa được biểu diễn dưới dạng bảng các trạng thái và hàm chuyển.
- Bảng gồm 3 cột, cột đầu tiên là các trạng thái đại diện cho các lớp tương đương, cột thứ 2 và 3 là trạng thái đích thu được khi trạng thái ở cột 1 khi có từ ngữ đầu vào tương ứng.

# Tài liệu tham khảo
Thuật toán tối tiểu hóa  https://en.wikipedia.org/wiki/DFA_minimization  

