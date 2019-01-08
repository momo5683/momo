namespace lehongson_1706020071_cuoiky
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.tsbLine = new System.Windows.Forms.ToolStripButton();
            this.tsbTriangle = new System.Windows.Forms.ToolStripButton();
            this.tsbRhombus = new System.Windows.Forms.ToolStripButton();
            this.Load = new System.Windows.Forms.ToolStripButton();
            this.Save = new System.Windows.Forms.ToolStripButton();
            this.paper = new System.Windows.Forms.PictureBox();
            this.toolStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.paper)).BeginInit();
            this.SuspendLayout();
            // 
            // toolStrip1
            // 
            this.toolStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsbLine,
            this.tsbTriangle,
            this.tsbRhombus,
            this.Load,
            this.Save});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(672, 47);
            this.toolStrip1.TabIndex = 0;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // tsbLine
            // 
            this.tsbLine.Image = ((System.Drawing.Image)(resources.GetObject("tsbLine.Image")));
            this.tsbLine.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsbLine.Name = "tsbLine";
            this.tsbLine.Size = new System.Drawing.Size(40, 44);
            this.tsbLine.Text = "Line";
            this.tsbLine.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            this.tsbLine.Click += new System.EventHandler(this.tsbLine_Click);
            // 
            // tsbTriangle
            // 
            this.tsbTriangle.Image = ((System.Drawing.Image)(resources.GetObject("tsbTriangle.Image")));
            this.tsbTriangle.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsbTriangle.Name = "tsbTriangle";
            this.tsbTriangle.Size = new System.Drawing.Size(66, 44);
            this.tsbTriangle.Text = "Triangle";
            this.tsbTriangle.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            this.tsbTriangle.Click += new System.EventHandler(this.tsbTriangle_Click);
            // 
            // tsbRhombus
            // 
            this.tsbRhombus.Image = ((System.Drawing.Image)(resources.GetObject("tsbRhombus.Image")));
            this.tsbRhombus.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tsbRhombus.Name = "tsbRhombus";
            this.tsbRhombus.Size = new System.Drawing.Size(75, 44);
            this.tsbRhombus.Text = "Rhombus";
            this.tsbRhombus.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            // 
            // Load
            // 
            this.Load.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.Load.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.Load.Name = "Load";
            this.Load.Size = new System.Drawing.Size(46, 44);
            this.Load.Text = "Load";
            this.Load.TextImageRelation = System.Windows.Forms.TextImageRelation.TextBeforeImage;
            this.Load.Click += new System.EventHandler(this.Load_Click_1);
            // 
            // Save
            // 
            this.Save.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.Save.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.Save.Name = "Save";
            this.Save.Size = new System.Drawing.Size(44, 44);
            this.Save.Text = "Save";
            this.Save.Click += new System.EventHandler(this.Save_Click_1);
            // 
            // paper
            // 
            this.paper.Location = new System.Drawing.Point(12, 61);
            this.paper.Name = "paper";
            this.paper.Size = new System.Drawing.Size(647, 379);
            this.paper.TabIndex = 1;
            this.paper.TabStop = false;
            this.paper.MouseDown += new System.Windows.Forms.MouseEventHandler(this.paper_MouseDown_1);
            this.paper.MouseMove += new System.Windows.Forms.MouseEventHandler(this.paper_MouseMove_1);
            this.paper.MouseUp += new System.Windows.Forms.MouseEventHandler(this.paper_MouseUp_1);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(672, 442);
            this.Controls.Add(this.paper);
            this.Controls.Add(this.toolStrip1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.paper)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripButton tsbLine;
        private System.Windows.Forms.ToolStripButton tsbTriangle;
        private System.Windows.Forms.ToolStripButton tsbRhombus;
        private System.Windows.Forms.ToolStripButton Load;
        private System.Windows.Forms.ToolStripButton Save;
        private System.Windows.Forms.PictureBox paper;
    }
}

