using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Drawing;
using Newtonsoft.Json;

namespace lehongson_1706020071_cuoiky
{
    class vehinh
    {
        public List<Diem> save = new List<Diem>();
        public virtual void Draw(Pen pen, Graphics g)
        {

        }
        public vehinh()
        {

        }
        /// <summary>
        /// dùng để load dữ liệu được lưu từ data chính và phần loại dữ liệu vào từng đối tượng khác nhau
        /// </summary>
        /// <param name="input"></param>
        /// <param name="input_Name"></param>
        public void LoadData(Dictionary<string, List<Diem>> input, string input_Name)
        {
            foreach (var item in input)
            {
                if (item.Key == input_Name)
                {
                    save = item.Value;
                }
            }
        }
        public List<Diem> SaveData()
        {
            List<Diem> temp = new List<Diem>();
            temp = save;
            return temp;
        }
    }
    class Line : vehinh
    {
        public Diem begin = new Diem();
        public Diem end = new Diem();
        public Line()
        {
            begin = new Diem(0, 0);
            end = new Diem(0, 0);
        }
        public Line(Diem A, Diem B)
        {
            begin = A;
            end = B;
        }
        /// <summary>
        /// dùng để vẽ lại tất các đường đã được lêu trong đối tượng này
        /// </summary>
        /// <param name="g"></param>
        /// <param name="pen"></param>
        public void Draw(Pen pen, Graphics g)
        {
            foreach (var item in save)
            {
                for (int i = 0; i < save.Count - 1; i += 2)
                {
                    g.DrawLine(pen, save[i].x, save[i].y, save[i + 1].x, save[i + 1].y);
                }
            }
        }
        public void AddPoint()
        {
            try
            {
                save.Add(begin);
                save.Add(end);
            }
            catch (Exception)
            {
            }
        }
    }
    class Triangle : vehinh
    {
        public Diem begin = new Diem();
        public Diem end = new Diem();
        public Diem momo = new Diem();
        public Triangle()
        {
            begin = new Diem(0, 0);
            momo = new Diem(0, 0);
            end = new Diem(0, 0);
        }
        public Triangle(Diem A, Diem B, Diem C)
        {
            begin = A;
            end = B;
            momo = C;
        }
        public override void Draw(Pen pen, Graphics g)
        {
            base.Draw(pen, g);
            Rectangle rect = new Rectangle();
            rect.Size = new Size(end.x - begin.x, end.y - begin.y);
            rect.X = begin.x;
            rect.Y = begin.y;
            g.DrawLine(pen,  rect.X, rect.Y + rect.Height, end.x, end.y);
            g.DrawLine(pen, rect.X, rect.Y, end.x, end.y);
            g.DrawLine(pen, rect.X, rect.Y, end.x - rect.Width, end.y);
        }
        public void AddPoint()
        {
            try
            {
                save.Add(begin);
                save.Add(end);
            }
            catch (Exception)
            {
            }
        }
    }
}
