Dungeon Bomberman

-------------------------------------
Player: 
Khởi tạo: Mạng: 3, Bomb: 1, Độ dài boom: 1, Điểm: 0, Key: không có

-------------------------------------
ENEMIES:
Skeleton1 : Di chuyển lên xuống hoặc trái phải
Skeleton2 : Di chuyển ngẫu nhiên lên xuống, trái phải, có 0.5% khả năng trên %giây đột nhiên chuyển hướng
Skull : Di chuyển ngẫu nhiên chéo, có 0.5% khả năng trên %giây đột nhiên chuyển hướng
Vampire : Di chuyển mọi hướng, tốc độ thay đổi liên tục, khó đoán

-------------------------------------
ITEMS: ( đều có xác suất rơi ra khi nổ 1 interface)
Red Flask : Tăng mạng
Blue Flask : Tăng bomb
Green Flask : Tăng độ dài bomb
Key : Có key mới qua được màn, mỗi màn tối thiểu 1 key có sẵn trên bản đồ
Coin : Tăng điểm

-------------------------------------
TRAPS : Player chạm vào sẽ trừ một mạng và reset vị trí ban đầu

-------------------------------------
INTERFACES: 2 loại chính, khi khởi tạo có thể khởi tạo ngẫu nhiên trên bản đồ
- Nổ được: + Có Item: có xác xuất rơi ra ngẫu nhiên Items
	   + Không có Item: không rơi ra Items
- Không thể nổ vào có thể đi qua

Ladder: Player di chuyển đến ladder khi đã tiêu diệt hết enemies và có key để qua màn
