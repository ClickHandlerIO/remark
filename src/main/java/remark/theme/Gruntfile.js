module.exports = function (grunt) {
    'use strict';


    grunt.initConfig({
        clean: {
            build: {
                options: {
                    force: true
                },
                src: ["../public/css/", "../public/fonts/", "../public/js/", "../public/skins/", "../public/vendor/"]
            }
        },
        copy: {
            main: {
                files: [
                    {
                        expand: true,
                        cwd: 'global/css/',
                        src: ['*.min.css'],
                        dest: '../public/css/'
                    },
                    {
                        expand: true,
                        cwd: 'base/assets/css/',
                        src: ['*.min.css'],
                        dest: '../public/css/'
                    },
                    {
                        expand: true,
                        cwd: 'global/fonts/',
                        src: ['**'],
                        dest: '../public/fonts/'
                    },
                    {
                        expand: true,
                        cwd: 'global/js/',
                        src: ['**'],
                        dest: '../resources/js/'
                    },
                    {
                        expand: true,
                        cwd: 'base/assets/js/',
                        src: ['**'],
                        dest: '../resources/js/'
                    },
                    {
                        expand: true,
                        cwd: 'base/assets/examples/js',
                        src: ['**'],
                        dest: '../resources/js/examples'
                    },
                    {
                        expand: true,
                        cwd: 'base/assets/skins/',
                        src: ['**'],
                        dest: '../resources/skins/'
                    },
                    {
                        expand: true,
                        cwd: 'global/vendor/',
                        src: ['**'],
                        dest: '../resources/vendor/'
                    },
                    {
                        expand: true,
                        cwd: 'global/vendor/',
                        src: ['**/*.css'],
                        dest: '../public/vendor/'
                    },
                    {
                        expand: true,
                        cwd: 'base/assets/examples/css',
                        src: ['**'],
                        dest: '../public/css'
                    },
                    {
                        expand: true,
                        cwd: 'base/assets/examples/css',
                        src: ['**'],
                        dest: '../resources/css'
                    },
                    {
                        expand: true,
                        cwd: 'base/assets/examples/images/',
                        src: ['**'],
                        dest: '../public/images/'
                    },
                    {
                        expand: true,
                        cwd: 'global/vendor/modernizr',
                        src: ['**'],
                        dest: '../public/vendor/modernizr'
                    },
                    {
                        expand: true,
                        cwd: 'global/vendor/breakpoints',
                        src: ['**'],
                        dest: '../public/vendor/breakpoints'
                    },
                    {
                        expand: true,
                        cwd: 'global/portraits',
                        src: ['**'],
                        dest: '../public/images/portraits'
                    }
                ]
            }
        }
    });

    grunt.registerTask('global-dist', function () {
        var cb = this.async();
        grunt.util.spawn({
            grunt: true,
            args: ['dist'],
            opts: {
                cwd: 'global'
            }
        }, function (error, result, code) {
            console.log(result.stdout);
            cb();
        });
    });

    grunt.registerTask('base-dist', function () {
        var cb = this.async();
        grunt.util.spawn({
            grunt: true,
            args: ['dist'],
            opts: {
                cwd: 'base'
            }
        }, function (error, result, code) {
            console.log(result.stdout);
            cb();
        });
    });

    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.registerTask('default', ['clean', 'global-dist', 'base-dist', 'copy']);
};
