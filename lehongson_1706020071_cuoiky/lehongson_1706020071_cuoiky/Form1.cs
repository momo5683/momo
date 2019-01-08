using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Newtonsoft.Json;
using System.IO;

namespace lehongson_1706020071_cuoiky
{
    public partial class Form1 : Form
    {
        Dictionary<string, List<Diem>> data = new Dictionary<string, List<Diem>>();//đối tượng để lưu dư liệu tổng
        Graphics g;//đối tượng nền
        Pen pen = new Pen(Color.Red, 1);//cây bút để vẽ
        bool canDraw = false;//kiểm tra điều kiện có thể vẽ hay không
        Diem begin = new Diem();//điểm bắt đầu vẽ
        Diem end = new Diem();//điểm kết thúc
        Line line = new Line();//tao đối tượng đường thằng
        Triangle triangle = new Triangle();//tạo đối tượng hình tròn
        Rectangle rect = new Rectangle();//tạo vùng tiếp diện hình chữ nhật
        bool pointer, isLine, isTriangle;//kiểm tra menu chọn
        public Form1()
        {
            InitializeComponent();
            g = paper.CreateGraphics();
            pointer = true;
            isTriangle = false;
            isLine = false;
        }
        void Update()
        {
            for (int i = 0; i < line.save.Count - 1; i += 2)
            {
                line.Draw(pen, g);
            }
            for (int i = 0; i < triangle.save.Count - 1; i += 2)
            {
                triangle.Draw(pen, g);
            }
        }

       
        private void paper_MouseUp_1(object sender, MouseEventArgs e)
        {
            if (pointer == false)
            {
                end.x = e.X;
                end.y = e.Y;
                canDraw = false;
                if (isLine)
                {
                    line.begin = begin;
                    line.end = end;
                    line.AddPoint();
                }
                else if (isTriangle)
                {
                    triangle.begin = begin;
                    triangle.end = end;
                    triangle.AddPoint();
                }

            }

        }

        private void paper_MouseDown_1(object sender, MouseEventArgs e)
        {
            if (pointer == false)
            {
                canDraw = true;
                begin = new Diem(e.X, e.Y);
                rect.X = begin.x;
                rect.Y = begin.y;
            }

        }

        private void paper_MouseMove_1(object sender, MouseEventArgs e)
        {

            if (canDraw == true)
            {
                end = new Diem(e.X, e.Y);
                g.Clear(paper.BackColor);
                if (pointer)
                {
                    return;
                }
                else if (isLine == true)
                {
                    g.DrawLine(pen, begin.x, begin.y, e.X, e.Y);
                }
                else if (isTriangle == true)
                {
                    Rectangle rect = new Rectangle();
                    rect.Size = new Size(end.x - begin.x, end.y - begin.y);
                    rect.X = begin.x;
                    rect.Y = begin.y;
                    g.DrawLine(pen, rect.X, rect.Y + rect.Height, end.x, end.y);
                    g.DrawLine(pen, rect.X, rect.Y, end.x, end.y);
                    g.DrawLine(pen, rect.X, rect.Y, end.x - rect.Width, end.y);
                }
                Update();
            }
        }

        private void tsbLine_Click(object sender, EventArgs e)
        {
            pointer = false;
            isLine = true;
            isTriangle = false;
        }

        private void Load_Click_1(object sender, EventArgs e)
        {
            pointer = true;
            isTriangle = false;
            isLine = false;
            OpenFileDialog open = new OpenFileDialog();
            open.Filter = "json| *.json";
            open.ShowDialog();
            StreamReader reader = new StreamReader(open.FileName);
            var json = reader.ReadToEnd();
            data = JsonConvert.DeserializeObject<Dictionary<string, List<Diem>>>(json);
            line.LoadData(data, "line");
            triangle.LoadData(data, "tam giac");
            reader.Close();
            Update();
        }

        private void Save_Click_1(object sender, EventArgs e)
        {
            pointer = true;
            isTriangle = false;
            isLine = false;
            SaveFileDialog save = new SaveFileDialog();
            save.Filter = "json| *.json";
            save.ShowDialog();
            data.Add("line", line.SaveData());
            data.Add("tam giac", triangle.SaveData());
            StreamWriter writer = new StreamWriter(save.FileName);
            var json = JsonConvert.SerializeObject(data);
            writer.Write(json);
            writer.Close();
        }

        private void tsbTriangle_Click(object sender, EventArgs e)
        {
            pointer = false;
            isLine = true;
            isTriangle = false;
           
        }
    }
}
